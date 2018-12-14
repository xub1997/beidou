package com.beidou.gateway.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "公司信息类")
public class Company {


    @ApiModelProperty(value="公司id", hidden=false, required=false, dataType="Integer")
    private Integer id;

    @ApiModelProperty(value="公司名字", hidden=false, required=true, dataType="String")
    private String name;

    @ApiModelProperty(value="公司描述", hidden=false, required=true, dataType="String")
    private String description;

    @ApiModelProperty(value="公司地址", hidden=false, required=true, dataType="String")
    private String address;

    @ApiModelProperty(value="公司电话", hidden=false, required=true, dataType="String")
    private String phone;

    @ApiModelProperty(value="创建时间", hidden=false, required=false, dataType="String")
    private String createdate;

    @ApiModelProperty(value="修改时间", hidden=false, required=false, dataType="String")
    private String modifydate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
}