package com.beidou.gateway.service;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.gateway.dao.DeptMapper;
import com.beidou.gateway.entity.Dept;
import com.beidou.gateway.entity.DeptExample;
import com.beidou.gateway.entity.vo.DeptVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public ResponseMsg insert(Dept dept){
        dept.setCreatedate(StringUtil.dateToString(new Date()));
        dept.setModifydate(StringUtil.dateToString(new Date()));
        if(deptMapper.insert(dept)>0&&true){
            return ResponseMsg.Success("保存部门信息成功");
        }
        return ResponseMsg.Error("保存部门信息失败");
    }

    public ResponseMsg getById(Integer id){
        List<Dept> dept=new ArrayList<>();
        dept.add(deptMapper.selectByPrimaryKey(id));
        if(dept!=null&&true){
            return ResponseMsg.Success("获取部门信息成功",dept);
        }
        return ResponseMsg.Error("获取部门信息失败");
    }

    public ResponseMsg updateById(Dept dept){
        dept.setModifydate(StringUtil.dateToString(new Date()));
        if(deptMapper.updateByPrimaryKeySelective(dept)>0&&true){
            return ResponseMsg.Success("更新部门信息成功");
        }
        return ResponseMsg.Error("更新部门信息失败");
    }

    public ResponseMsg deleteById(Integer id){
        if(deptMapper.deleteByPrimaryKey(id)>0&&true){
            return ResponseMsg.Success("删除部门信息成功");
        }
        return ResponseMsg.Error("删除部门信息失败");
    }

    public ResponseMsg deleteBatch(List<Integer> del_ids){
        DeptExample deptExample=new DeptExample();
        DeptExample.Criteria criteria = deptExample.createCriteria();
        //遍历数组
        criteria.andIdIn(del_ids);
        if(deptMapper.deleteByExample(deptExample)>0&&true){
            return ResponseMsg.Success("批量删除部门信息成功");
        }
        return ResponseMsg.Error("批量删除部门信息失败");
    }

    public ResponseMsg getComDept(Integer comId) {
        List<Dept> dept=deptMapper.selectByComId(comId);
        if(dept!=null&&true){
            return ResponseMsg.Success("获取公司部门成功",dept);
        }else{
            return ResponseMsg.Error("获取公司部门失败");
        }
    }

    public ResponseMsg getAll(){
        List<Dept> depts = deptMapper.selectByExample(null);
        if(depts!=null&&true){
            return ResponseMsg.Success("获取部门信息成功",depts);
        }
        return ResponseMsg.Error("获取部门信息失败");
    }

    public ResponseMsg getList(Integer pageNum, Integer pageSize){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, pageSize);
        List<DeptVO> depts = deptMapper.getAll();
        if(depts!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(depts, 5);
            return ResponseMsg.Success("获取部门信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取部门信息列表失败");
    }

    public ResponseMsg getComDeptList(Integer pageNum,int comId){
        List<Dept> depts = deptMapper.selectByComId(comId);
        if(depts!=null&&true){
            // 这不是一个分页查询
            // 引入PageHelper分页插件
            // 在查询之前只需要调用，传入页码，以及每页的大小
            PageHelper.startPage(pageNum, 20);
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(depts, 5);
            return ResponseMsg.Success("获取公司部门列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取公司部门列表失败");
    }

    public ResponseMsg searchByName(Integer pageNum,Integer pageSize,String name){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, pageSize);
        List<Dept> depts = deptMapper.searchByName(name);
        if(depts!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(depts, 5);
            return ResponseMsg.Success("查找部门成功",pageInfo);
        }
        return ResponseMsg.Error("查找部门失败");
    }

    public ResponseMsg searchByNameAndComId(Integer pageNum,String name, Integer comId){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum, 20);
        List<Dept> depts = deptMapper.searchByNameAndComId(name,comId);
        if(depts!=null&&true){
            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(depts, 5);
            return ResponseMsg.Success("查找公司部门成功",pageInfo);
        }
        return ResponseMsg.Error("查找公司部门失败");
    }


}
