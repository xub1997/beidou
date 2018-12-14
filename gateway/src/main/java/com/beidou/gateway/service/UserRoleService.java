package com.beidou.gateway.service;


import com.beidou.common.entity.ResponseMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Service
@FeignClient(value = "user")
public interface UserRoleService {

    @PostMapping(value = "/userRole")
    public ResponseMsg insert(@RequestParam(value = "userId")Integer userId, @RequestParam("roleIds")String roleIds);

    @PutMapping(value="/userRole")
    public ResponseMsg updateByUserId(@RequestParam(value = "userId")Integer userId, @RequestParam("roleIds")String roleIds);


}
