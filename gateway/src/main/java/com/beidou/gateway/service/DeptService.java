package com.beidou.gateway.service;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.Dept;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Service
@FeignClient(value = "user")
public interface DeptService {


    @PostMapping(value = "/dept")
    public ResponseMsg insert(Dept dept);



    @GetMapping(value="/dept/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id);


    @PutMapping(value="/dept/{id}")
    public ResponseMsg updateById(Dept dept);


    @DeleteMapping(value="/dept/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids);


    @GetMapping(value="/comDept")
    public ResponseMsg getComDept(@RequestParam(value = "comId", defaultValue = "1")Integer comId );


    @GetMapping(value="/dept")
    public ResponseMsg getAll();


    @GetMapping(value="/depts")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum );


    @GetMapping(value="/comDepts")
    public ResponseMsg getComDeptList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                      @RequestParam(value = "comId", defaultValue = "1")Integer comId );


    @GetMapping(value="/dept/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                    @RequestParam(value = "name")String name );


    @GetMapping(value="/dept/searchByNameAndComId")
    public ResponseMsg searchByNameAndComId(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                            @RequestParam(value = "name")String name,@RequestParam("comId")Integer comId );

}
