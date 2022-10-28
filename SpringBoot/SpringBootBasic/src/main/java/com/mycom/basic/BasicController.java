package com.mycom.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class BasicController {
	
	@RequestMapping(value="/")
	public String home() { // return 되는 문자열 앞 뒤에 ...jsp 찾아가는... ( home.jsp 찾아갔었는데... )
		return "home";
	}
}
