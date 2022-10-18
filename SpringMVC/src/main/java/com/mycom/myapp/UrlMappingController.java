package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UrlMappingController {
	
	@RequestMapping("/hello")
	public void m1() {
		System.out.println("/hello");
	}
	
	@RequestMapping("/hello/ssafy")
	public void m2() {
		System.out.println("/hello/ssafy");
	}
	
	@RequestMapping(value={"/url1","url2"})
	public void m3() {
		System.out.println("/url1, /url2");
	}
	
	@RequestMapping(value="/method", method=RequestMethod.GET)
	public void m4() {
		System.out.println("/method/GET");
	}
	
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public void m5() {
		System.out.println("/method/POST");
	}

	@RequestMapping(value="/method", method=RequestMethod.PUT)
	public void m6() {
		System.out.println("/method/PUT");
	}

	
	@RequestMapping(value="/method", method=RequestMethod.DELETE)
	public void m7() {
		System.out.println("/method/DELETE");
	}

}
