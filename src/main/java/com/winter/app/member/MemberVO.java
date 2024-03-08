package com.winter.app.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString  // 정보를 리턴해줌
public class MemberVO {

	
	@NotBlank(message = "입력하셈")  // default 메시지가 존재하나 변경할수있음
	private String username;
	
	private String passwordCheck;
	
	
	@NotBlank  // 라이브러리 추가하면 사용할수있음 Spring Form 검증 설정
	@Size(min=8, max=16)  // 문자열 길이 제한
	private String password;
	

	private String phone;
	
	@Email
	private String email;
	private String address;
	private String name;
	
	
	
	
}
