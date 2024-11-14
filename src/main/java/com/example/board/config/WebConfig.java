package com.example.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {
    private  String resourcePath ="/upload/**"; //view 에서 접근할 경로
//    private  String savePath ="file:///C:/springboot_img/";  //실제 파일 저장 경로 (윈도우)
    private  String savePath ="file:///Users/yangjihun/springboot_ing/";  //실제 파일 저장 경로 (맥)

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
