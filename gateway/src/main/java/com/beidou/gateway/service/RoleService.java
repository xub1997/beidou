package com.beidou.gateway.service;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;




@Service
@FeignClient(value = "user")
public interface RoleService {


    @PostMapping(value = "/role")
    public ResponseMsg insert(Role role);



    @GetMapping(value="/role/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id);



    @PutMapping(value="/role/{id}")
    public ResponseMsg updateById(Role role);



    @DeleteMapping(value="/role/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids);



    @GetMapping(value="/roles")
    public ResponseMsg getAll(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum );


    @GetMapping(value="/role/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                    @RequestParam(value = "name")String name );

}
