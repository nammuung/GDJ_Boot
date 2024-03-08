package com.winter.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("add")
	public void add (@ModelAttribute MemberVO memberVO) throws Exception{

	}
	
	@PostMapping("add")
	//@Valid 사용할떄 BindingResult 매개변수로 선언해야함
	// bindingResult -> 검증된 데이터를 담는 역할
	public String add(@Valid MemberVO memberVO, BindingResult bindingResult, Model model) throws Exception{
		log.info("Member Add");
		
		boolean check = memberService.checkMember(memberVO, bindingResult);
		if(check) {
			return "member/add";
		}
		
		int result = memberService.add(memberVO);
		model.addAttribute("result","member.add.result");
		model.addAttribute("path", "/");
		
		return "commons/result";
//		// 검증할때 에러가 있으면 다시 되돌아가라
//		if(bindingResult.hasErrors()) {
//			return "member/add";
//		}
		
		
		// 성공시 서비스로 보냄
		
//		return "redirect:/"; 
		
		
	}
	
	
	
	
	
	
	
	
}
