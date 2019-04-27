package com.beidou.logger.service;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.logger.dao.SysLogMapper;
import com.beidou.logger.entity.SysLog;
import com.beidou.logger.entity.SysLogExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Example;
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
    public PageInfo getAllList(int pageNum,int pageSize){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小

        SysLogExample sysLogExample=new SysLogExample();
        SysLogExample.Criteria criteria = sysLogExample.createCriteria();
        criteria.andIdIsNotNull();
        sysLogExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum, pageSize);
        List<SysLog> sysLogs = sysLogMapper.selectByExample(sysLogExample);
        PageInfo pageInfo = new PageInfo(sysLogs, 5);
        return pageInfo;
    }

    /*
    * 获取对应用户的最新操作日志（倒叙）
    * */
    public PageInfo getMyList(int pageNum,int pageSize,String username){

        SysLogExample sysLogExample=new SysLogExample();
        SysLogExample.Criteria criteria = sysLogExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        sysLogExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum, pageSize);
        List<SysLog> sysLogs = sysLogMapper.selectByExample(sysLogExample);
        PageInfo pageInfo = new PageInfo(sysLogs, 5);
        return pageInfo;
    }

    /*
    * 查找用户的操作日志
    * */
    public PageInfo searchByUsername(int pageNum,int pageSize,String username){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, pageSize);
        List<SysLog> sysLogs = sysLogMapper.searchByUsername(username);
        PageInfo pageInfo = new PageInfo(sysLogs, 5);
        return pageInfo;
    }

    public SysLog getById(int id){
        return sysLogMapper.selectByPrimaryKey(id);
    }

}
