package com.beidou.user.service;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.entity.Rule;
import com.beidou.gateway.entity.RuleExample;
import com.beidou.user.dao.RuleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RuleService {

    @Autowired
    private RuleMapper ruleMapper;

    public ResponseMsg insert(Rule rule){
        rule.setCreatedate(StringUtil.dateToString(new Date()));
        rule.setModifydate(StringUtil.dateToString(new Date()));
        if(ruleMapper.insert(rule)>0&&true){
            return ResponseMsg.Success("保存权限信息成功");
        }
        return ResponseMsg.Error("保存权限信息失败");
    }

    public ResponseMsg getById(Integer id){
        List<Rule> rule=new ArrayList<>();
        rule.add(ruleMapper.selectByPrimaryKey(id));
        if(rule!=null&&true){
            return ResponseMsg.Success("获取权限信息成功",rule);
        }
        return ResponseMsg.Error("获取权限信息失败");
    }

    public ResponseMsg updateById(Rule rule){
        rule.setModifydate(StringUtil.dateToString(new Date()));
        if(ruleMapper.updateByPrimaryKeySelective(rule)>0&&true){
            return ResponseMsg.Success("更新权限信息成功");
        }
        return ResponseMsg.Error("更新权限信息失败");
    }

    public ResponseMsg deleteById(Integer id){
        if(ruleMapper.deleteByPrimaryKey(id)>0&&true){
            return ResponseMsg.Success("删除权限信息成功");
        }
        return ResponseMsg.Error("删除权限信息失败");
    }

    public ResponseMsg deleteBatch(List<Integer> del_ids){
        RuleExample ruleExample=new RuleExample();
        RuleExample.Criteria criteria = ruleExample.createCriteria();
        //遍历数组
        criteria.andIdIn(del_ids);
        if(ruleMapper.deleteByExample(ruleExample)>0&&true){
            return ResponseMsg.Success("批量删除权限信息成功");
        }
        return ResponseMsg.Error("批量删除权限信息失败");
    }

    public ResponseMsg getList(Integer pageNum){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Rule> rules = ruleMapper.selectByExample(null);
        if(rules!=null&&true){
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(rules, 5);
            return ResponseMsg.Success("获取权限信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取权限信息列表失败");
    }

    public ResponseMsg getRoleRule(Integer roleId){
        List<Rule> rules=ruleMapper.getRoleRule(roleId);
        if(rules!=null&&true){
            return ResponseMsg.Success("获取角色权限成功",rules);
        }else{
            return ResponseMsg.Error("获取角色权限失败");
        }
    }


    public ResponseMsg searchByName(Integer pageNum,String name){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Rule> rules = ruleMapper.searchByName(name);
        if(rules!=null&&true){
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(rules, 5);
            return ResponseMsg.Success("获取权限信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取权限信息列表失败");
    }


    public  ResponseMsg  getAll(){
        List<Rule> rules = ruleMapper.selectByExample(null);
        if(rules!=null&&true){
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            return ResponseMsg.Success("获取权限信息列表成功",rules);
        }else {
            return ResponseMsg.Error("获取权限信息列表失败");
        }
    }

}
