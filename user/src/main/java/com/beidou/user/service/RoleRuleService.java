package com.beidou.user.service;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.user.dao.RoleRuleMapper;
import com.beidou.gateway.entity.RoleRule;
import com.beidou.gateway.entity.RoleRuleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleRuleService {

    @Autowired
    private RoleRuleMapper roleRuleMapper;

    public ResponseMsg insert(RoleRule roleRule){
        if(roleRuleMapper.insert(roleRule)>0&&true){
            return ResponseMsg.Success("保存角色权限成功");
        }
        return ResponseMsg.Error("保存角色权限失败");
    }

    public ResponseMsg batchInsert(Integer roleId, List<Integer> add_ids){
        List<RoleRule> roleRules=new ArrayList<>();
        for(int i=0;i<add_ids.size();i++){
            RoleRule roleRule=new RoleRule(roleId,add_ids.get(i));
            roleRules.add(roleRule);
        }
        if(roleRuleMapper.batchInsert(roleRules)>0&&true){
            return ResponseMsg.Success("保存角色权限成功");
        }
        return ResponseMsg.Error("保存角色权限失败");
    }

    public ResponseMsg updateByRoleId(RoleRule roleRule){
        RoleRuleExample roleRuleExample=new RoleRuleExample();
        RoleRuleExample.Criteria criteria =roleRuleExample.createCriteria();
        criteria.andRoleidEqualTo(roleRule.getRoleid());
        if(roleRuleMapper.deleteByExample(roleRuleExample)>0){
            if(roleRuleMapper.insert(roleRule)>0&&true){
                return ResponseMsg.Success("修改角色权限成功");
            }
        }

        return ResponseMsg.Error("修改角色权限失败");
    }

    public ResponseMsg updateByRoleIdBatch(Integer roleId,List<Integer> add_ids){
        RoleRuleExample roleRuleExample=new RoleRuleExample();
        RoleRuleExample.Criteria criteria =roleRuleExample.createCriteria();
        criteria.andRoleidEqualTo(roleId);
        List<RoleRule> roleRules=new ArrayList<>();
        for(int i=0;i<add_ids.size();i++){
            RoleRule roleRule=new RoleRule(roleId,add_ids.get(i));
            roleRules.add(roleRule);
        }
        if(roleRuleMapper.deleteByExample(roleRuleExample)>0){
            if(roleRuleMapper.batchInsert(roleRules)>0&&true){
                return ResponseMsg.Success("修改角色权限成功");
            }
        }

        return ResponseMsg.Error("修改角色权限失败");
    }

}
