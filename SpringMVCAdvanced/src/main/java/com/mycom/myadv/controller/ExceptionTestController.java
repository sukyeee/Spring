package com.mycom.myadv.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

// 예외 처리 2 가지
// #1. Controller 별 처리
// #2. Global 처리 

@Controller
public class ExceptionTestController {
	@GetMapping(value="/exception")
	private void makeException()  {
		System.out.println("/exception");
		
		// #1 throw RuntimeException
//		throw new RuntimeException();
		
		String str = null;
		str.length(); // nullPointerException 발생 
		
		
	}
	
	// Controller 별 처리
	// 현재 컨트롤러에서 발생하는 예외 중 아래 표기한 예외 및 하위 예외를 처리 
	@ExceptionHandler({IOException.class, SQLException.class})
	public String handlerError1(HttpServletRequest req, Model model, Exception e) {
		// 요청한 url 에 대해서 오류가 발생했음을 jsp 로 보내서 표현 
		System.out.println("handlerError1");
		model.addAttribute("url", req.getRequestURL());
		model.addAttribute("exception", e);
		return "error"; // error.jsp 로 forwarding
		
	}
	

}







