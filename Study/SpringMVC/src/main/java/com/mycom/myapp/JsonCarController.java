package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycom.myapp.dto.CarDto;

@Controller
public class JsonCarController {
	
	@PostMapping("/car")
	public void m1(@RequestBody CarDto dto) {
		System.out.println(dto);
	}
}
