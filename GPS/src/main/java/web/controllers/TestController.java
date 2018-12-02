package web.controllers;

import business.entity.ActualPos;
import business.entity.Position;
import business.entity.repositories.EnclosureRepositories;
import business.entity.repositories.JdbcActualPositionDao;
import business.entity.warn.Enclosure;
import business.util.MyDateFormat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/test")
public class TestController{
    /*
    @Resource(name = "GpsTrackSessionFactory")
    private Object sessionFactory;

    private DataSource dataSource;

    private Session session;

    private Connection connection;

    private Statement statement;

    private Transaction transaction;

    public void createTable() throws SQLException{
        System.out.println((SessionFactory)sessionFactory);
        session = ((SessionFactory)sessionFactory).openSession();
        connection = SessionFactoryUtils.getDataSource((SessionFactory) sessionFactory).getConnection();
        transaction = session.getTransaction();
        statement = connection.createStatement();
        String name = Long.valueOf(System.currentTimeMillis()).toString();
        statement.execute("CREATE TABLE t1(\n" +
                "    id int not null,\n" +
                "    name char(20)\n" +
                ");");
    }

    @RequestMapping(path = "addtable")
    public void create() throws SQLException {
        createTable();
    }
    */

    @Autowired
    private EnclosureRepositories enclosureRepositories;

    @Autowired
    private MyDateFormat dateFormat;

    @Autowired
    private JdbcActualPositionDao jdbcActualPositionDao;

    @RequestMapping
    public String createTable() throws SQLException {
        jdbcActualPositionDao.createTableByName(dateFormat.myformat());
        jdbcActualPositionDao.ifTableExist("magician2018-05-03");
        jdbcActualPositionDao.ifTableExist("2018-05-03");
        ActualPos actualPos = new ActualPos();
        Position position = new Position();
        position.setLon("113.48559");
        position.setLat("23.108082");
        actualPos.setCar_id((long) 1);
        actualPos.setPosition(position);
        jdbcActualPositionDao.insertActualPos(dateFormat.myformat(),actualPos);
        jdbcActualPositionDao.findPosByCarAndDate("magician2018-05-03",(long)1,new Date(118,4,1),new Date(119,1,1));
        return "index";
    }

    @RequestMapping(path = "/enc")
    public String testEnclosure(){
        List<Enclosure> list = enclosureRepositories.findAllByValidAndInvalid(new Date());
        System.out.println(list.size());
        return "enclosure";
    }

    @RequestMapping(path = "/date")
    public String testDate(@RequestBody Date date){
        System.out.println(date.toString());
        return "enclosure";
    }
}
