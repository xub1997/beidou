package com.beidou.gateway.service;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.dao.RoleMapper;
import com.beidou.gateway.entity.Role;
import com.beidou.gateway.entity.RoleExample;
import com.beidou.gateway.entity.Rule;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public ResponseMsg insert(Role role){
        role.setCreatedate(StringUtil.dateToString(new Date()));
        role.setModifydate(StringUtil.dateToString(new Date()));
        if(roleMapper.insert(role)>0&&true){
            return ResponseMsg.Success("保存角色信息成功");
        }
        return ResponseMsg.Error("保存角色信息失败");
    }

    public ResponseMsg getById(Integer id){
        List<Role> role=new ArrayList<>();
        role.add(roleMapper.selectByPrimaryKey(id));
        if(role!=null&&true){
            return ResponseMsg.Success("获取角色信息成功",role);
        }
        return ResponseMsg.Error("获取角色信息失败");
    }

    public ResponseMsg updateById(Role role){
        role.setModifydate(StringUtil.dateToString(new Date()));
        if(roleMapper.updateByPrimaryKeySelective(role)>0&&true){
            return ResponseMsg.Success("更新角色信息成功");
        }
        return ResponseMsg.Error("更新角色信息失败");
    }

    public ResponseMsg deleteById(Integer id){
        if(roleMapper.deleteByPrimaryKey(id)>0&&true){
            return ResponseMsg.Success("删除角色信息成功");
        }
        return ResponseMsg.Error("删除角色信息失败");
    }

    public ResponseMsg deleteBatch(List<Integer> del_ids){
        RoleExample roleExample=new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        //遍历数组
        criteria.andIdIn(del_ids);
        if(roleMapper.deleteByExample(roleExample)>0&&true){
            return ResponseMsg.Success("批量删除角色信息成功");
        }
        return ResponseMsg.Error("批量删除角色信息失败");
    }

    public ResponseMsg getList(Integer pageNum){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<Role> roles = roleMapper.selectByExample(null);
        if(roles!=null&&true){
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(roles, 5);
            return ResponseMsg.Success("获取角色信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取角色信息列表失败");
    }


    public ResponseMsg searchByName(Integer pageNum,String name){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<Role> roles = roleMapper.searchByName(name);
        if(roles!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询

            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(roles, 5);
            return ResponseMsg.Success("获取角色信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取角色信息列表失败");
    }


    public ResponseMsg getUserRole(Integer userId){
        List<Role> rules=roleMapper.getUserRole(userId);
        if(rules!=null&&true){
            return ResponseMsg.Success("获取用户角色成功",rules);
        }else{
            return ResponseMsg.Error("获取用户角色失败");
        }
    }


    public ResponseMsg getAll(){
        List<Role> roles = roleMapper.selectByExample(null);
        if(roles!=null&&true){
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            return ResponseMsg.Success("获取角色信息列表成功",roles);
        }
        return ResponseMsg.Error("获取角色信息列表失败");
    }

}
