package com.beidou.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "upload.path")
public class UploadConfig {
    private String uploadPath;
    private String realPath;
    private String filePath;
    private String uploadMatch;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadMatch() {
        return uploadMatch;
    }

    public void setUploadMatch(String uploadMatch) {
        this.uploadMatch = uploadMatch;
    }
}
