package com.winter.app.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration // xml
public class MessageConfig implements WebMvcConfigurer {
//같은 클래스 내에서 사용하게 될 경우에 Bean을 사용하지 않음
    @Bean
    LocaleResolver localeResolver() {
		
    	// session이나 cookie중에 하나만 사용하면 댐
    	// session
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
		
		//cookie
		CookieLocaleResolver cResolver = new CookieLocaleResolver();
		cResolver.setDefaultLocale(Locale.KOREAN);
		
		return resolver;
	}
    
    // 라이브러리를 받아와서 인터셉터를 적용
    // Bean으로 등록해서 interceptorConif에서 가져가서 쓸경우 Bean사용
    // 클래스 내에서 할때는 bean사용 안함
    @Bean
    LocaleChangeInterceptor changeInterceptor() {
    	LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
    	changeInterceptor.setParamName("lang");
    	return changeInterceptor;
    }
    
    
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(changeInterceptor()).add
//	
//	}
    
    
    
}
