package com.beidou.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "权限信息类")
public class Rule {

    @ApiModelProperty(value="权限id", hidden=false, required=false, dataType="Integer")
    private Integer id;

    @ApiModelProperty(value="权限名称", hidden=false, required=true, dataType="String")
    private String rulename;

    @ApiModelProperty(value="权限描述", hidden=false, required=true, dataType="String")
    private String description;

    @ApiModelProperty(value="权限url", hidden=false, required=true, dataType="String")
    private String url;

    @ApiModelProperty(value="父级id", hidden=false, required=true, dataType="String")
    private Integer pid;

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

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename == null ? null : rulename.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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