package com.winter.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.winter.app.interceptors.LoginInterceptor;
import com.winter.app.interceptors.TestInterceptor;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer{
	
	@Autowired
	private TestInterceptor testInterceptor;

	@Autowired
	private LoginInterceptor loginInterceptor;
	
	
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	
	@Override  // 여러개하려면 registry 여러개 쓰면댐
	// 여러개 등록이 되어있는 상태에서 중복이되면 class순서대로 적용이 됨
	public void addInterceptors(InterceptorRegistry registry) {
		// 어떤 URL이 들어 왔을떄 어떤 인터셉터를 거치게 할거냐?
		
//		registry.addInterceptor(testInterceptor)
//		.addPathPatterns("/notice/**")
//		.excludePathPatterns("/notice/add");
//		
//		
//		registry.addInterceptor(loginInterceptor)
//		.addPathPatterns("")
//		.excludePathPatterns("");
		
		registry.addInterceptor(localeChangeInterceptor)
		.addPathPatterns("/**");
	}
	
	

}
