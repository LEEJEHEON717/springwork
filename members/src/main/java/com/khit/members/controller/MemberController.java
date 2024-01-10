package com.khit.members.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.members.dto.MemberDTO;
import com.khit.members.service.Memberservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	
	private Memberservice memberService;
	
	@GetMapping("/join")
	public String index() {
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDTO memberDTO) {
		log.info("memberDTO=" + memberDTO);
		//회원 가입 처리(저장)
		memberService.insert(memberDTO);
		return "/member/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO,
			HttpSession session) {
		MemberDTO loginMember = memberService.login(memberDTO);
		if(loginMember !=null) {
			session.setAttribute("sessionEmail", memberDTO.getEmail());
			return "main";
		}else {
			return "/member/login";
		}
	}
}
