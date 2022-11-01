package com.mycom.myboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController 아님. 비동기 요청에 대한 처리 controller 가 아님. 페이지 이동에 대한 역할 수행
@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home() {
		return "/index.html"; // static folder 의 index.html 로 이동
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "/login.html";
	}
	
	@GetMapping(value = "/register")
	public String register() {
		return "/register.html";
	}
	
	@GetMapping(value = "/board")
	public String board() {
		return "/board/boardMain.html";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login.html";
	}
}
