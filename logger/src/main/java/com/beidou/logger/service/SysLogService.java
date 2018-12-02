package com.beidou.logger.service;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.logger.dao.SysLogMapper;
import com.beidou.logger.entity.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public void getAllList(int pageNum){

    }

    /*
    * 获取对应用户的最新操作日志（倒叙）
    * */
    public void getMyList(int pageNum,String username){

    }

    /*
    * 查找用户的操作日志
    * */
    public void searchByUsername(int pageNum,String username){

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
