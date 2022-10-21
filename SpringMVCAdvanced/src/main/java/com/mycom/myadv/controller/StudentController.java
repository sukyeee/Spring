package com.mycom.myadv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myadv.dto.StudentDto;
import com.mycom.myadv.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
//	이렇게 써도 된다 
//	@PostMapping(value="/students")
//	public int studentInsert(@RequestBody StudentDto dto){ // FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
//		System.out.println(dto);
//		int ret = service.studentInsert(dto);
//		return ret;
//	}
	
	@PostMapping(value="/students")
	public ResponseEntity<Integer> studentInsert(@RequestBody StudentDto dto){ // FrontEnd 에서 json 으로 데이터가 넘어오지 않는다.
		System.out.println(dto);
		int ret = service.studentInsert(dto);
		return new ResponseEntity<Integer>(ret, HttpStatus.OK);
	}
	
	
	
}
