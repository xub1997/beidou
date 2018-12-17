package com.beidou.gateway.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户角色信息类")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 131L;

    @ApiModelProperty(value="用户角色id", hidden=false, required=false, dataType="Integer")
    private Integer id;

    @ApiModelProperty(value="用户id", hidden=false, required=true, dataType="Integer")
    private Integer userid;

    @ApiModelProperty(value="角色id", hidden=false, required=true, dataType="Integer")
    private Integer roleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public UserRole(Integer userid, Integer roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }
}