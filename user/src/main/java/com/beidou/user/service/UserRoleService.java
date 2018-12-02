package com.beidou.user.service;

import com.beidou.user.dao.UserRoleMapper;
import com.beidou.user.entity.UserRole;
import com.beidou.user.entity.UserRoleExample;
import com.beidou.user.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public ResponseMsg insert(UserRole userRole){
        if(userRoleMapper.insert(userRole)>0&&true){
            return ResponseMsg.Success("保存用户角色成功");
        }
        return ResponseMsg.Error("保存用户角色失败");
    }

    public ResponseMsg batchInsert(Integer userId, List<Integer> add_ids){
        List<UserRole> userRoles=new ArrayList<>();
        for(int i=0;i<add_ids.size();i++){
            UserRole userRole=new UserRole(userId,add_ids.get(i));
            userRoles.add(userRole);
        }
        if(userRoleMapper.batchInsert(userRoles)>0&&true){
            return ResponseMsg.Success("保存用户角色成功");
        }
        return ResponseMsg.Error("保存用户角色失败");
    }

    public ResponseMsg updateByUserId(UserRole userRole){
        UserRoleExample userRoleExample=new UserRoleExample();
        UserRoleExample.Criteria criteria =userRoleExample.createCriteria();
        criteria.andUseridEqualTo(userRole.getUserid());
        if(userRoleMapper.deleteByExample(userRoleExample)>0){
            if(userRoleMapper.insert(userRole)>0&&true){
                return ResponseMsg.Success("修改用户角色成功");
            }
        }
        return ResponseMsg.Error("修改用户角色失败");
    }

    public ResponseMsg updateByUserIdBatch(Integer userId,List<Integer> add_ids){
        UserRoleExample UserRoleExample=new UserRoleExample();
        UserRoleExample.Criteria criteria =UserRoleExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<UserRole> userRoles=new ArrayList<>();
        for(int i=0;i<add_ids.size();i++){
            UserRole userRole=new UserRole(userId,add_ids.get(i));
            userRoles.add(userRole);
        }
        if(userRoleMapper.deleteByExample(UserRoleExample)>0){
            if(userRoleMapper.batchInsert(userRoles)>0&&true){
                return ResponseMsg.Success("修改用户角色成功");
            }
        }
        return ResponseMsg.Error("修改用户角色失败");
    }

}
