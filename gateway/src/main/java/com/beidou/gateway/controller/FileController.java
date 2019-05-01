package com.beidou.gateway.controller;

import com.beidou.common.annotation.SysLogger;
import com.beidou.common.entity.ResponseMsg;
import com.beidou.gateway.config.UploadConfig;
import com.beidou.gateway.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 *
 * 头像上传
 */
@Api(value = "FileController|头像上传操作")
@RestController
@RequestMapping("/api/v1/user")
public class FileController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UploadConfig uploadConfig;

    @SysLogger("上传用户头像")
    @RequiresPermissions("userAvatar:create")
    @ApiOperation(value="上传用户头像", notes="上传用户头像")
    @PostMapping(value = "/userAvatar/upload")
    public ResponseMsg uploadUserAvatar(MultipartFile file){
        //判空
        if(file.isEmpty()){
            logger.info("上传文件为空");
            return ResponseMsg.Error("文件为空！");
        }else{
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            if(suffixName.equals(".jpg")||suffixName.equals(".jpeg")||suffixName.equals(".png")||suffixName.equals(".gif")){

                File dest = new File(uploadConfig.getRealPath() + fileName);
                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                    return ResponseMsg.Success("上传成功",uploadConfig.getUploadPath()+fileName);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                logger.info("上传失败");
                return ResponseMsg.Error("上传失败");
            }else {
                logger.info("文件格式错误！");
                return ResponseMsg.Error("文件格式错误！");
            }
        }
    }



}
