package com.mycom.myapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class JsonController {

	@PostMapping(value="/emp")
	public void m1(@RequestBody EmpDto dto) {
	    System.out.println(dto);
	}
	
	@PostMapping(value="/empList")
	public void m2(@RequestBody List<EmpDto> empList) {
	    for (EmpDto empDto : empList) {
	        System.out.println(empDto);
	    }
	}
	
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto m3(@PathVariable int employeeId) {
	    System.out.println(employeeId);
	    
	    // employeeId 에 맞는 EmpDto 객치를 만들어서 json으로 response
	    EmpDto empDto = new EmpDto(2000, "길동4", "홍4", "hong@d.com", "2022-10-23");
	    
	    // 위에 만든 empDto를 json 으로 어떻게 처리??
	    return empDto;
	}
	@GetMapping(value="/empList")
	@ResponseBody
	public List<EmpDto> m4() {
		
		// employeeId 에 맞는 EmpDto 객치를 만들어서 json으로 response		
		EmpDto empDto = new EmpDto(2000, "길동4", "홍4", "hong@d.com", "2022-10-23");
		EmpDto empDto1 = new EmpDto(2001, "길동5", "홍5", "hong@d.com", "2022-10-23");
		EmpDto empDto2 = new EmpDto(2002, "길동6", "홍2", "hong@d.com", "2022-10-23");
		
		List<EmpDto> list = new ArrayList<>();
		list.add(empDto);
		list.add(empDto1);
		list.add(empDto2);
		// 위에 만든 empDto를 json 으로 어떻게 처리??
		return list;
	}
	
	@GetMapping(value="/localDateTime")
	@ResponseBody
	public LocalDateTime m5() {
	    return LocalDateTime.now();
	}
}