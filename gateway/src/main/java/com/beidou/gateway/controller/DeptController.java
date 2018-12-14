package com.beidou.gateway.controller;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.Dept;
import com.beidou.gateway.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequiresPermissions("dept:create")
    @PostMapping(value = "/dept")
    public ResponseMsg insert(Dept dept){
        return deptService.insert(dept);
    }


    @RequiresPermissions("dept:read")
    @GetMapping(value="/dept/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id){
        return deptService.getById(id);
    }

    @RequiresPermissions("dept:update")
    @PutMapping(value="/dept/{id}")
    public ResponseMsg updateById(Dept dept){
        return deptService.updateById(dept);
    }

    @RequiresPermissions("dept:delete")
    @DeleteMapping(value="/dept/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids){
        return deptService.deleteById(ids);
    }

    @RequiresPermissions("comDept:read")
    @GetMapping(value="/comDept")
    public ResponseMsg getComDept(@RequestParam(value = "comId", defaultValue = "1")Integer comId ){
        return deptService.getComDept(comId);
    }

    @RequiresPermissions("dept:readAll")
    @GetMapping(value="/dept")
    public ResponseMsg getAll(){
        return deptService.getAll();
    }

    @RequiresPermissions("depts:read")
    @GetMapping(value="/depts")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ){
        return deptService.getList(pageNum);
    }

    @RequiresPermissions("comDepts:read")
    @GetMapping(value="/comDepts")
    public ResponseMsg getComDeptList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                      @RequestParam(value = "comId", defaultValue = "1")Integer comId ){
        return deptService.getComDeptList(pageNum,comId);
    }

    @RequiresPermissions("dept:searchByName:read")
    @GetMapping(value="/dept/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                    @RequestParam(value = "name")String name ){
        return deptService.searchByName(pageNum,name);
    }

    @RequiresPermissions("dept:searchByNameAndComId:read")
    @GetMapping(value="/dept/searchByNameAndComId")
    public ResponseMsg searchByNameAndComId(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                            @RequestParam(value = "name")String name,
                                            @RequestParam("comId")Integer comId ){
        return deptService.searchByNameAndComId(pageNum,name,comId);
    }

}
