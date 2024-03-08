package com.winter.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Configuration -> @@.xml 
@Configuration
public class FileMapping implements WebMvcConfigurer{

	
	@Value("${app.upload.url}")
	private String urlPath;  // /files/**

	@Value("${app.upload.base}")
	private String filePath; // d://upload/
	
	
// 요청 URL이 들어오면 다른경로로 보내주는 역할
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {

	registry.addResourceHandler(urlPath)
	.addResourceLocations(filePath);
	
}
	
	
	
}
