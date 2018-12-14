package com.beidou.logger.service;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.logger.dao.SysLogMapper;
import com.beidou.logger.entity.SysLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysLogService {
    private final static Logger logger = LoggerFactory.getLogger(SysLogService.class);

    @Autowired
    private SysLogMapper sysLogMapper;

    public void saveLogger(SysLog sysLog){
        if(sysLogMapper.insert(sysLog)>0&&true){
            logger.info("保存操作日志成功");
        }else{
            logger.info("保存操作日志失败");
        }
    }

    /*
    * 获取所有最新操作日志（倒叙）
    * */
    public ResponseMsg getAllList(int pageNum){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<SysLog> sysLogs = sysLogMapper.selectAll();
        if(sysLogs!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(sysLogs, 5);
            return ResponseMsg.Success("获取所有最新操作日志列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取所有最新操作日志列表失败");
    }

    /*
    * 获取对应用户的最新操作日志（倒叙）
    * */
    public ResponseMsg getMyList(int pageNum,String username){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<SysLog> sysLogs = sysLogMapper.selectAll();
        if(sysLogs!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(sysLogs, 5);
            return ResponseMsg.Success("获取对应用户的最新操作日志列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取对应用户的最新操作日志列表失败");
    }

    /*
    * 查找用户的操作日志
    * */
    public ResponseMsg searchByUsername(int pageNum,String username){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<SysLog> sysLogs = sysLogMapper.selectAll();
        if(sysLogs!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(sysLogs, 5);
            return ResponseMsg.Success("查找用户的操作日志列表成功",pageInfo);
        }
        return ResponseMsg.Error("查找用户的操作日志列表失败");
    }

    public ResponseMsg getById(int id){
        SysLog sysLog=sysLogMapper.selectByPrimaryKey(id);
        if(sysLog!=null&&true){
            return ResponseMsg.Success("获取用户对应操作日志成功",sysLog);
        }else{
            return ResponseMsg.Error("获取用户对应操作日志失败");
        }
    }

}
