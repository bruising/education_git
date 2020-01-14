package com.example.demoswg.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demoswg
 * @Package com.example.demoswg.utils
 * @date 2020/1/10 10:43 星期五
 */

/*
 *这是一个配置类（配置spring容器  <应用上下文>）
 * 可以启动组件扫描，用来将带有@Bean的实体进行实例化bean等
 */
@Configuration

public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter endpointExporter(){
        return new ServerEndpointExporter();
    }
}
