package com.beidou.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "角色-权限信息类")
public class RoleRule implements Serializable {
    private static final long serialVersionUID = 127L;

    @ApiModelProperty(value="角色-权限id", hidden=false, required=false, dataType="Integer")
    private Integer id;

    @ApiModelProperty(value="角色id", hidden=false, required=true, dataType="Integer")
    private Integer roleid;

    @ApiModelProperty(value="权限id", hidden=false, required=true, dataType="Integer")
    private Integer ruleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public RoleRule(Integer roleid, Integer ruleid) {
        this.roleid = roleid;
        this.ruleid = ruleid;
    }
}