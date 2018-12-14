package com.beidou.gateway.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "用户信息类")
public class User implements Serializable {

    private static final long serialVersionUID = 5231134212346077681L;

    @ApiModelProperty(value="用户id", hidden=false, required=false, dataType="Integer")
    private Integer id;

    @ApiModelProperty(value="用户名", hidden=false, required=true, dataType="String")
    private String username;

    @ApiModelProperty(value="盐值", hidden=false, required=false, dataType="String")
    private String salt;

    @ApiModelProperty(value="密码", hidden=false, required=true, dataType="String")
    private String pwd;

    @ApiModelProperty(value="创建时间", hidden=false, required=false, dataType="String")
    private String createdate;

    @ApiModelProperty(value="修改时间", hidden=false, required=false, dataType="String")
    private String modifydate;

    @ApiModelProperty(value="头像url", hidden=false, required=false, dataType="String")
    private String avatarurl;

    @ApiModelProperty(value="状态 (0不可用 1可用)", hidden=false, required=true, dataType="Integer")
    private Integer status;

    @ApiModelProperty(value="员工名字", hidden=false, required=true, dataType="String")
    private String name;

    @ApiModelProperty(value="手机", hidden=false, required=true, dataType="String")
    private String phone;

    @ApiModelProperty(value="年龄", hidden=false, required=true, dataType="Integer")
    private Integer age;

    @ApiModelProperty(value="性别（0男1女）", hidden=false, required=true, dataType="Integer")
    private Integer sex;

    @ApiModelProperty(value="住址", hidden=false, required=true, dataType="String")
    private String address;

    @ApiModelProperty(value="邮箱地址", hidden=false, required=true, dataType="String")
    private String email;

    @ApiModelProperty(value="职位", hidden=false, required=true, dataType="String")
    private String job;

    @ApiModelProperty(value="部门id", hidden=false, required=true, dataType="Integer")
    private Integer deptid;

    @ApiModelProperty(value="公司id", hidden=false, required=true, dataType="Integer")
    private Integer comid;

    @ApiModelProperty(value="备注", hidden=false, required=false, dataType="String")
    private String remark;

    //用户角色
    @ApiModelProperty(value="用户角色", hidden=true)
    private List<Role> roles=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getModifydate() {
        return modifydate;
    }

    public void setModifydate(String modifydate) {
        this.modifydate = modifydate == null ? null : modifydate.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salt='" + salt + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createdate='" + createdate + '\'' +
                ", modifydate='" + modifydate + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", job='" + job + '\'' +
                ", deptid=" + deptid +
                ", comid=" + comid +
                ", remark='" + remark + '\'' +
                ", roles=" + roles +
                '}';
    }
}