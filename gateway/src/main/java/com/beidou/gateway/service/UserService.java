package com.beidou.gateway.service;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;

import com.beidou.gateway.dao.UserMapper;
import com.beidou.gateway.entity.User;
import com.beidou.gateway.entity.UserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public ResponseMsg insert(User user){
        if(userMapper.judgeUsername(user.getUsername())==null){
            user.setCreatedate(StringUtil.dateToString(new Date()));
            user.setModifydate(StringUtil.dateToString(new Date()));
            String salt=UUID.randomUUID().toString().replaceAll("-","");
            user.setSalt(salt);
            user.setPwd(StringUtil.encryptByMD5(user.getPwd()+salt));
            if(userMapper.insert(user)>0&&true){
                return ResponseMsg.Success("保存用户信息成功");
            }
            return ResponseMsg.Error("保存用户信息失败");
        }else{
            return ResponseMsg.Error("用户名已存在");
        }

    }

    public ResponseMsg getById(Integer id){
        List<User> user=new ArrayList<>();
        user.add(userMapper.selectByPrimaryKey(id));
        if(user!=null&&true){
            return ResponseMsg.Success("获取用户信息成功",user);
        }
        return ResponseMsg.Error("获取用户信息失败");
    }

    public ResponseMsg updateById(User user){
        user.setModifydate(StringUtil.dateToString(new Date()));
        if(userMapper.updateByPrimaryKeySelective(user)>0&&true){
            return ResponseMsg.Success("更新用户信息成功");
        }
        return ResponseMsg.Error("更新用户信息失败");
    }

    public ResponseMsg deleteById(Integer id){
        if(userMapper.deleteByPrimaryKey(id)>0&&true){
            return ResponseMsg.Success("删除用户信息成功");
        }
        return ResponseMsg.Error("删除用户信息失败");
    }

    public ResponseMsg deleteBatch(List<Integer> del_ids){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        //遍历数组
        criteria.andIdIn(del_ids);
        if(userMapper.deleteByExample(userExample)>0&&true){
            return ResponseMsg.Success("批量删除用户信息成功");
        }
        return ResponseMsg.Error("批量删除用户信息失败");
    }

    public ResponseMsg getList(Integer pageNum){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<User> users = userMapper.selectByExample(null);
        if(users!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(users, 5);
            return ResponseMsg.Success("获取用户信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取用户信息列表失败");
    }

    public ResponseMsg getComUserList(Integer pageNum,Integer comId){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<User> users = userMapper.selectByComId(comId);
        if(users!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(users, 5);
            return ResponseMsg.Success("获取公司用户列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取公司用户列表失败");
    }

    public ResponseMsg searchByUserName(Integer pageNum,String username){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<User> users = userMapper.searchByUserName(username);
        if(users!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(users, 5);
            return ResponseMsg.Success("获取用户信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取用户信息列表失败");
    }

    public ResponseMsg searchByUserNameAndComId(Integer pageNum,String username,Integer comId){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<User> users = userMapper.searchByUserNameAndComId(username,comId);
        if(users!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(users, 5);
            return ResponseMsg.Success("获取用户信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取用户信息列表失败");
    }

    public User judgeUsername(String username){
        return userMapper.judgeUsername(username);
    }

    public ResponseMsg modifyPwd(Integer userId,String oldPwd,String newPwd){
        User user=userMapper.selectByPrimaryKey(userId);
        if(user!=null){
            oldPwd=StringUtil.encryptByMD5(oldPwd+user.getSalt());
            if(user.getPwd().equals(oldPwd)&&true){
                newPwd=StringUtil.encryptByMD5(newPwd+user.getSalt());
                user.setPwd(newPwd);
                user.setModifydate(StringUtil.dateToString(new Date()));
                if(userMapper.updateByPrimaryKeySelective(user)>0&&true){
                    return ResponseMsg.Success("密码修改成功");
                }else{
                    return ResponseMsg.Error("密码修改失败");
                }

            }else{
                return ResponseMsg.Error("原密码输入错误");
            }
        }else {
            return ResponseMsg.Error("不存在该用户");
        }

    }

}
