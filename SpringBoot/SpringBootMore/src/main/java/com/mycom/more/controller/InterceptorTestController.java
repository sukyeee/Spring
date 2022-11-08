package com.mycom.more.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 무조건 json response
public class InterceptorTestController {

	@GetMapping("/login") // login 페이지 이동 효과
	public String m1() {
		System.out.println("/login");
		return "/login"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
	
	@GetMapping("/login/ok") // login 성공 효과
	public String m2(HttpSession session) {
		System.out.println("/login/ok");
		session.setAttribute("login", "success");
		return "/login/ok"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
	
	@GetMapping("/logout") // logout 효과
	public String m3(HttpSession session) {
		System.out.println("/logout");
		session.invalidate();
		return "/logout"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
	
	@GetMapping("/users") // 일반 로그인 성공후 갈 수 있는 페이지 효과
	public String m4() {
		System.out.println("/users");
		return "/users"; // jsp 로 분기 X 그냥 문자열 그대로 json 으로 response
	}
	
	
}
