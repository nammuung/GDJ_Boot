package com.winter.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web
				.ignoring()
				.requestMatchers("/css/**")
				.requestMatchers("/js/**")
				.requestMatchers("/vendor/**")
				.requestMatchers("/img/**")
				.requestMatchers("/favicon/**")
				;
	}
	
	@Bean
	SecurityFilterChain filterChain (HttpSecurity security) throws Exception {
//		security.cors()
//				.and()
//				.csrf()
//				.disable();
		security
			//권한에 관련된 설정
			.authorizeHttpRequests(
				(authorizeRequests)->
					
						authorizeRequests
							.requestMatchers("/").permitAll()
							.requestMatchers("/member/add").permitAll()
							.requestMatchers("/member/page", "/member/logout").authenticated()
							.requestMatchers("/notice/list").authenticated()
							.requestMatchers("/notice/add", "/notice/delete").hasRole("ADMIN")
							.requestMatchers("/notice/update").hasAnyRole("ADMIN", "MANGER")
							.anyRequest().permitAll()
					
			)//authorizeHttpRequests 끝부분
			.formLogin(
					(login)->
						login
							.loginPage("/member/login")
							.defaultSuccessUrl("/")
							//파라미터이름이 username이 아닌 'id'를 사용 했을 경우
							//.usernameParameter("id")
							//파라미터이름이 password가 아닌 'pw'를 사용 했을 경우
							//.passwordParameter("pw")
							.permitAll()
			)//formLogin 끝부분
			.logout(
					(logout)->
						logout
							//.logoutUrl("/member/logout")
							.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
							.logoutSuccessUrl("/")
							.invalidateHttpSession(true) //로그아웃시 seession만료
							.permitAll()
			)
			
			;	
	
		
		
		
		
		
		
		
		return security.build();
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		//password 암호화 해주는 객체
		return new BCryptPasswordEncoder();
	}

}
