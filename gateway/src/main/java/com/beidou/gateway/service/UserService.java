package com.beidou.gateway.service;


import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;



@Service
@FeignClient(value = "user")
public interface UserService {


    @PostMapping(value = "/user")
    public ResponseMsg insert(User user);



    @GetMapping(value="/user/{id}")
    public ResponseMsg getById(@PathVariable("id")Integer id);


    @PutMapping(value="/user/{id}")
    public ResponseMsg updateById(User user);


    @DeleteMapping(value="/user/{ids}")
    public ResponseMsg deleteById(@PathVariable("ids")String ids);


    @GetMapping(value="/users")
    public ResponseMsg getList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum );


    @GetMapping(value="/user")
    public ResponseMsg getComUserList(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum ,
                                      @RequestParam(value = "comId", defaultValue = "1")Integer comId);


    @GetMapping(value="/user/searchByUserName")
    public ResponseMsg searchByUserName(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "username")String username );


    @GetMapping(value="/user/searchByUserNameAndComId")
    public ResponseMsg searchByUserNameAndComId(@RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                                                @RequestParam(value = "username")String username,
                                                @RequestParam("comId")Integer comId );



    @GetMapping(value="/user/judgeUserName")
    public ResponseMsg judgeUserName(@RequestParam(value = "username")String username );


    @GetMapping(value="/user/modifyPwd")
    public ResponseMsg modifyPwd(@RequestParam(value = "userId")Integer userId ,@RequestParam(value = "oldPwd")String oldPwd,
                                 @RequestParam(value = "newPwd")String newPwd);


}
