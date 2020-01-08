package com.pengyipeng.education.util.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QNConfig {

    /**
     * 创建七牛云的上传文件配置类
     * @return
     */
    @Bean
    public com.qiniu.storage.Configuration qiniuConfig() {
        return new com.qiniu.storage.Configuration(Zone.zone1());
    }

    /**
     * 创建文件上传管理类
     * @return
     */
    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }

    // 获取accessKey
    @Value("${qiniu.accessKey}")
    private String accessKey;
    // 获取secretKey
    @Value("${qiniu.secretKey}")
    private String secretKey;

    /**
     * 创建上传实例
     * @return
     */
    @Bean
    public Auth auth() {
        return Auth.create(accessKey, secretKey);
    }

    /**
     * 加载管理
     * @return
     */
    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(), qiniuConfig());
    }

    /**
     * 获取gson对象
     * @return
     */
    @Bean
    public Gson gson() {
        return new Gson();
    }


}
