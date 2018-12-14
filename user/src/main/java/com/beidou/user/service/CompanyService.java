package com.beidou.user.service;

import com.beidou.common.entity.ResponseMsg;
import com.beidou.common.util.StringUtil;
import com.beidou.user.entity.Company;
import com.beidou.user.entity.CompanyExample;
import com.beidou.user.dao.CompanyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;


    public ResponseMsg insert(Company company){
        company.setCreatedate(StringUtil.dateToString(new Date()));
        company.setModifydate(StringUtil.dateToString(new Date()));
        if(companyMapper.insert(company)>0&&true){
            return ResponseMsg.Success("保存公司信息成功");
        }
        return ResponseMsg.Error("保存公司信息失败");
    }

    public ResponseMsg getById(Integer id){
        List<Company> company=new ArrayList<>();
        company.add(companyMapper.selectByPrimaryKey(id));
        if(company!=null&&true){
            return ResponseMsg.Success("获取公司信息成功",company);
        }
        return ResponseMsg.Error("获取公司信息失败");
    }

    public ResponseMsg updateById(Company company){
        company.setModifydate(StringUtil.dateToString(new Date()));
        if(companyMapper.updateByPrimaryKeySelective(company)>0&&true){
            return ResponseMsg.Success("更新公司信息成功");
        }
        return ResponseMsg.Error("更新公司信息失败");
    }

    public ResponseMsg deleteById(Integer id){
        if(companyMapper.deleteByPrimaryKey(id)>0&&true){
            return ResponseMsg.Success("删除公司信息成功");
        }
        return ResponseMsg.Error("删除公司信息失败");
    }

    public ResponseMsg deleteBatch(List<Integer> del_ids){
        //删除公司
        CompanyExample companyExample=new CompanyExample();
        CompanyExample.Criteria criteria = companyExample.createCriteria();
        //遍历数组
        criteria.andIdIn(del_ids);
        if(companyMapper.deleteByExample(companyExample)>0&&true){
            return ResponseMsg.Success("批量删除公司信息成功");
        }
        return ResponseMsg.Error("批量删除公司信息失败");
    }

    public ResponseMsg getAll(){
        List<Company> companys = companyMapper.selectByExample(null);
        if(companys!=null&&true){
            return ResponseMsg.Success("获取公司信息成功",companys);
        }
        return ResponseMsg.Error("获取公司信息失败");
    }

    public ResponseMsg getList(Integer pageNum){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum,20,true);
        List<Company> companys = companyMapper.selectByExample(null);
        if(companys!=null&&true){

            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(companys, 5);
            return ResponseMsg.Success("获取公司信息列表成功",pageInfo);
        }
        return ResponseMsg.Error("获取公司信息列表失败");
    }

    public ResponseMsg searchByName(Integer pageNum,String name){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pageNum,20,true);
        List<Company> companys = companyMapper.searchByName(name);
        if(companys!=null&&true){

            // startPage后面紧跟的这个查询就是一个分页查询
            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo pageInfo = new PageInfo(companys, 5);
            return ResponseMsg.Success("查找公司成功",pageInfo);
        }
        return ResponseMsg.Error("查找公司失败");
    }

}
