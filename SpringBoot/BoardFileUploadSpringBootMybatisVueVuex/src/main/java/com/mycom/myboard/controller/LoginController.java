package com.mycom.myboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.service.LoginService;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class LoginController {

	@Autowired
	LoginService service;
	
	@PostMapping(value="/login")
	public ResponseEntity<Map<String, String>> login(
			@RequestBody UserDto dto, // vue 에서 json 이 아닌 방식으로 넘길 경우, @RequestBody 제거
			HttpSession session
	){

		UserDto userDto = service.login(dto);
		Map<String, String> map = new HashMap<>();
		System.out.println(userDto);
		if( userDto != null ) {
			session.setAttribute("userDto", userDto);
			
		    map.put("result", "success");
		    map.put("userName", userDto.getUserName());
		    map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		}
		map.put("result", "fail");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}
	
}
