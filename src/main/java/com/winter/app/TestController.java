package com.winter.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j  // 로그를 찍을수 있는 어너테이션
public class TestController {
	@GetMapping("/")
	public String test () {
		// 순서 trace -> debug -> info -> warn -> error
		log.error("error Test");
		log.warn("warn Test");
		log.info("info Test");
		log.debug("debug Test");
		log.trace("trace Test");
		return "index";
	}
	
	
}
