package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/book")
public class UrlMappingController {
	// servlet에서는 /가 반드시 필요하나, spring에서는 생략 가능
//	@RequestMapping("hello")
//	public void m0() {
//		System.out.println("hello called");
//	}
	
	// servlet에서는 /* (*가 하나만 인식)
	// servlet에서는 /** 는 없음
	@RequestMapping("/sub/*")	// sub 다음
	public void m01() {
		System.out.println("/sub/* called");
	}
	
	// 이전에 /sub/*이 없으면 /sub/33  얘도 m02로 들어감
	// 이후 /sub/*** 없으면 /sub/../../../... 얘도 m02로 들어감
	@RequestMapping("/sub/**")	// sub 다다음
	public void m02() {
		System.out.println("/sub/** called");
	}
	
	@RequestMapping("/hello/ssafy")
	public void m2() {
		System.out.println("/hello/ssafy called");
	}
	
	@RequestMapping({"/url1","/url2"})
	public void m3() {
		System.out.println("/url1, /url2 called");
	}
	
	@RequestMapping(value="/method", method=RequestMethod.GET)
	public void m4() {
		System.out.println("/method/GET called");
	}
	@RequestMapping(value="/method", method=RequestMethod.POST)
	public void m5() {
		System.out.println("/method/POST called");
	}
	
	@RequestMapping(value="/method", method=RequestMethod.PUT)
	public void m6() {
		System.out.println("/method/PUT called");
	}
	@RequestMapping(value="/method", method=RequestMethod.DELETE)
	public void m7() {
		System.out.println("/method/DELETE called");
	}
	
	// book 수정
	// localhost:8080/myapp/book/123 PUT  <= 123번 책을 수정
	@RequestMapping(value="/book/{bookNo}", method=RequestMethod.PUT)
	public void m8(@PathVariable String bookNo) {
		System.out.println("/method/PUT called");
		System.out.println(bookNo);
	}
	
	// book 삭제
	// localhost:8080/myapp/book/123 DELETE  <= 123번 책을 삭제
	@RequestMapping(value="/book/{bookNo}", method=RequestMethod.DELETE)
	public void m9(@PathVariable int bookNo) {
		System.out.println("/method/DELETE called");
		System.out.println(bookNo);
	}
	
	// localhost:8080/myapp/book/ssafy/and/spring GET  <= bookNo, bookTitle로 조회
	@RequestMapping(value="/book/{writer}/and/{title}", method=RequestMethod.GET)
	public void m10(@PathVariable String writer, @PathVariable String title) {
		System.out.println("/book/GET called");
		System.out.println(writer);
		System.out.println(title);
	}
	
	@GetMapping(value="getMapping")
	public void m11() {
		System.out.println("/getMapping called");
	}
	
	@PostMapping(value="postMapping")
	public void m12() {
		System.out.println("/postMapping called");
	}
	@PutMapping(value="putMapping")
	public void m13() {
		System.out.println("/putMapping called");
	}
}
