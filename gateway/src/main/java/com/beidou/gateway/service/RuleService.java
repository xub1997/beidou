package com.beidou.gateway.service;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.Rule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;



@Service
@FeignClient(value = "user")
public interface RuleService {


    @PostMapping(value = "/rule")
    public ResponseMsg insert(Rule rule);

    @GetMapping(value="/rule/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id);

    @PutMapping(value="/rule/{id}")
    public ResponseMsg updateById(Rule rule);

    @DeleteMapping(value="/rule/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids);

    @GetMapping(value="/rules")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum );

    @GetMapping(value="/roleRule")
    public ResponseMsg getRoleRule(@RequestParam("roleId")Integer roleId );

    @GetMapping(value="/rule/searchByName")
    public ResponseMsg searchByName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                    @RequestParam(value = "name")String name );
}
