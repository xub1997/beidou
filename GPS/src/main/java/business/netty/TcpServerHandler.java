package business.netty;

import business.entity.ActualPos;
import business.entity.Car;
import business.entity.Position;
import business.entity.repositories.CarRepositories;
import business.entity.repositories.CarStopPosRepositories;
import business.entity.repositories.EnclosureRepositories;
import business.entity.repositories.JdbcActualPositionDao;
import business.entity.warn.Enclosure;
import business.services.EnclosureServices;
import business.util.MyDateFormat;
import business.util.maputil.GpsToBaidu;
import business.util.maputil.ParseUtil;
import business.util.maputil.Point;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ChannelHandler.Sharable
@Component
public class TcpServerHandler extends ChannelInboundHandlerAdapter{

    @Autowired
    private EnclosureRepositories enclosureRepositories;

    @Autowired
    private EnclosureServices enclosureServices;

    @Autowired
    private CarStopPosRepositories carStopPosRepositories;

    @Autowired
    private CarRepositories carRepositories;

    @Autowired
    private JdbcActualPositionDao actualPositionDao;

    @Autowired
    private MyDateFormat myDateFormat;

    private static final Logger log = LoggerFactory.getLogger(TcpServerHandler.class);

    @Override
    public void channelRegistered(ChannelHandlerContext ctx){
        log.info("registered:"+ctx.channel().remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("localhost:"+ctx.channel().localAddress()+"\treceive data:"+msg+"\tfrom\t"+ctx.channel().remoteAddress());
        String messege = msg.toString().trim();
        if(isValid(messege)){
            String[] arr= messege.substring(1).split(",");
            Car car = carRepositories.findByCard(Long.valueOf(arr[0]));
            if (car != null) {
                carStopPosRepositories.queryCarStopPosByCar(arr[1], arr[2], car);
                ActualPos actualPos = new ActualPos();
                actualPos.setPosition(new Position(arr[1],arr[2]));
                actualPos.setCar_id(car.getCard());
                actualPos.setLocal_time(new Date());
                getWarnTypeAndMessage(car,actualPos);//得到该车辆的报警信息并存入数据库
                actualPositionDao.insertActualPos(myDateFormat.myformat(),actualPos);
                ctx.channel().writeAndFlush("y");
                return;
            }
        }
        ctx.channel().writeAndFlush("n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.channel().write(cause.toString());
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx){
        log.info("unregistered:"+ctx.channel().remoteAddress());
    }

    private boolean isValid(String messege){
        if (!messege.startsWith("M"))return false;
        if (messege.substring(1).split(",").length != 3)return false;
        return true;
    }

    private void getWarnTypeAndMessage(Car car, ActualPos actualPos){
        List<Enclosure> list = enclosureRepositories.findAllByValidAndInvalid(new Date());
        ParseUtil util = new ParseUtil();
        for(Enclosure enclosure : list){
            List<Car> mylist = new ArrayList<>(enclosure.getCars());
            if(mylist.contains(car)){
                Point point = new Point(Double.valueOf(actualPos.getPosition().getLon())
                        ,Double.valueOf(actualPos.getPosition().getLat()));
                double[] latlng = GpsToBaidu.postBaidu(point.lat,point.lon);//gps转百度地图坐标
                point.lat = latlng[0]; point.lon = latlng[1];
                String shape = enclosure.getShape();
                boolean isIn = false;
                switch (enclosure.getEnclosuretype()){
                    case CIRCLE:
                        isIn = enclosureServices.isPointInCircle(point,util.parseCircle(shape));
                        break;
                    case POLYGON:
                        isIn = enclosureServices.isPointInPolygon(point,util.parsePolygon(shape));
                        break;
                    case RECTANGLE:
                        isIn = enclosureServices.isPointInRect(point,util.parseRectangle(shape));
                        break;
                }
                if (enclosure.getEnclosurewarntype().getName().equals("INWARN")){
                    if (isIn) {
                        actualPos.setWarn_status(1);
                        actualPos.setWarn_message("INWARN");
                    }else {
                        actualPos.setWarn_status(0);
                    }
                }else {
                    if (!isIn) {
                        actualPos.setWarn_status(2);
                        actualPos.setWarn_message("OUTWARN");
                    }else {
                        actualPos.setWarn_status(0);
                    }
                }
            }
        }
    }

}


