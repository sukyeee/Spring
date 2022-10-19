package com.mycom.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.hw.dto.UserDto;
import com.mycom.hw.service.UserService;

@Controller
public class DBController {

	@Autowired
	UserService service;
	
	@GetMapping(value="/")
	public String dbTest() {
		System.out.println("DBController / ");
		return "dbTest";
	}
	
	// json으로 response W
	@GetMapping(value="/userDetail/{userId}")
	@ResponseBody
	public UserDto userDetail(@PathVariable String userId) {
		System.out.println(userId);
		UserDto dto = service.userDetail(userId);
		return dto;
	}
	
	@GetMapping(value="/userList")
	@ResponseBody
	public List<UserDto> userList(){
		
		List<UserDto> list = service.userList();
		
		return list;
	}
	
	@PostMapping(value="/userInsert")
	@ResponseBody
	public int userInsert(UserDto userDto){ // FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(userDto);
		
		int ret = service.userInsert(userDto);	
		return ret;
	}
	
	@PostMapping(value="/userDelete")
	@ResponseBody
	public int userDelete(String userId){ // FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(userId);
		
		int ret = service.userDelete(userId);	
		return ret;
	}
	
	@PostMapping(value="/userUpdate")
	@ResponseBody
	public int empUpdate(UserDto empDto){ // FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(empDto);
		
		int ret = service.userUpdate(empDto);	
		return ret;
	}
	
	
}
