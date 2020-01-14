package com.example.demoswg.utils;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demoswg
 * @Package com.example.demoswg.utils
 * @date 2020/1/8 10:58 星期三
 */
@Configuration
public class QNConfig {
    @Bean
    public com.qiniu.storage.Configuration qiniuiConfig(){
        return new com.qiniu.storage.Configuration(Zone.zone0());
    }
    @Bean
    public UploadManager uploadManager(){
        return new UploadManager(qiniuiConfig());

    }
    @Value("VrJO5gWALhBZ1OfVi1tNOKiv3hoV4lax54fnTlJ5")
    private String accessKey;
    @Value("WrhV0weN7zpAmQFyJ8pkfoLv25SbXEBPJpgKPovy")
    private String secretkey;
    @Bean
    public Auth auth(){
        return  Auth.create(accessKey,secretkey);
    }
    @Bean
    public BucketManager bucketManager(){
        return  new BucketManager(auth(),qiniuiConfig());
    }
    @Bean
    public Gson gson(){
        return new Gson();
    }
}
