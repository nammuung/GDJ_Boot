package com.winter.app.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class TestInterceptor implements HandlerInterceptor{

	
	@Override // 컨트롤러 진입전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
 
		log.info("========= POST =========");
		return true;
	}

	@Override // 컨트롤러에서 서블릿나가기전
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.info("======================post==============");
	}

	@Override // jsp끝나기전
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		log.info("==========after=================");
	}
	
	
	
	
	
	
}
