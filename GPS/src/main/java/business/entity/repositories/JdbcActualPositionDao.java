package business.entity.repositories;

import business.entity.ActualPos;
import business.entity.GpsStatus;
import business.entity.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcActualPositionDao{

    private static final Logger log = LoggerFactory.getLogger(JdbcActualPositionDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "pDataSource")
    private DataSource dataSource;

    @Autowired
    private DateFormat dateFormat;

    @Autowired
    public void setDataSource(){
        jdbcTemplate.setDataSource(dataSource);
    }

    public void createTableByName(String name){
        try {
            if (ifTableExist(name)) return;
            String sql = "CREATE TABLE `" + name + "` (\n" +
                    "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                    "  `car_id` bigint(20) NOT NULL,\n" +
                    "  `local_time` datetime DEFAULT NULL,\n" +
                    "  `dop` double DEFAULT NULL,\n" +
                    "  `gps_status` int(11) DEFAULT NULL,\n" +
                    "  `lat` varchar(255) DEFAULT NULL,\n" +
                    "  `lon` varchar(255) DEFAULT NULL,\n" +
                    "  `sat_num` int(11) DEFAULT NULL,\n" +
                    "  `speed` int(11) DEFAULT NULL,\n" +
                    "  `utc` datetime DEFAULT NULL,\n" +
                    "  `warn_status` int(11) DEFAULT NULL,\n" +
                    "  `warn_message` varchar(255) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=MyISAM DEFAULT CHARSET=utf8;\n";
            jdbcTemplate.execute(sql);
        }catch (Exception e){
            log.error("createTableByName create table "+name+" failed");
        }
    }

    public void createTableBySql(String sql){
        jdbcTemplate.execute(sql);
    }

    public void insertActualPos(String tablename,ActualPos actualPos){
        try {
            String sql = "insert into `" + tablename + "` (car_id,local_time,lon,lat,utc,gps_status,speed,dop,warn_status,warn_message) values("
                    + actualPos.getCar_id() + ","
                    + datetosql(actualPos.getLocal_time()) + ","
                    + actualPos.getPosition().getLon() + ","
                    + actualPos.getPosition().getLat() + ","
                    + datetosql(actualPos.getPosition().getUtc()) + ","
                    + actualPos.getPosition().getGpsStatus() + ","
                    + actualPos.getPosition().getSpeed() + ","
                    + actualPos.getPosition().getDop() + ","
                    + actualPos.getWarn_status() + ","
                    + "'"+actualPos.getWarn_message()+"'"
                    + ");";
            jdbcTemplate.execute(sql);
        }catch (Exception e){
            log.error("insertActualPos failed to insert data to " + tablename);
        }
    }

    public void insertBySql(String sql){
        jdbcTemplate.execute(sql);
    }

    public boolean ifTableExist(String name){
        String sql = "SELECT table_name FROM information_schema.TABLES WHERE table_name ='"+name+"';";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        return !list.isEmpty();
    }

    public ActualPos findSingalPosByCar(String tablename, Long car_id, Date date){
        String sql = "SELECT * FROM `" + tablename + "` WHERE car_id =" + car_id + " date=" + datetosql(date) + ";";
        return translate(jdbcTemplate.queryForList(sql)).get(0);
    }

    public List<ActualPos> findPosByCarAndDate(String tablename, Long car_id, Date begin, Date end){
        try {
            String sql = "SELECT * FROM `" + tablename + "` WHERE car_id=" + car_id + " AND DATE(local_time) BETWEEN " + datetosql(begin) + " AND " + datetosql(end) + ";";
            return translate(jdbcTemplate.queryForList(sql));
        }catch (Exception e){
            log.error("findSingalPosByCar failed to select data from "+ tablename);
            return new ArrayList<>();
        }
    }

    private String datetosql(Date date){ return date == null ? null : "'"+dateFormat.format(date)+"'"; }

    private List<ActualPos> translate(List<Map<String, Object>> list)  {
        List<ActualPos> actualPosList = new ArrayList<>();
        for (Map<String, Object> it : list){
            ActualPos actualPos = new ActualPos();
            Position position = new Position();
            position.setUtc((Date) it.get("utc"));
            position.setLat((String) it.get("lat"));
            position.setLon((String) it.get("lon"));
            position.setDop((Double) it.get("dop"));
            position.setSpeed((Integer) it.get("speed"));
            position.setSat_num((Integer) it.get("sat_num"));
            position.setGpsStatus(GpsStatus.fornumber((Integer) it.get("gps_status")));
            actualPos.setId((Long) it.get("id"));
            actualPos.setCar_id((Long) it.get("car_id"));
            actualPos.setLocal_time((Date) it.get("local_time"));
            actualPos.setPosition(position);
            actualPosList.add(actualPos);
        }
        return actualPosList;
    }
}
