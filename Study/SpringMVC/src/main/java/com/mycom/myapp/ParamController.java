package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {

	
	@GetMapping("/param1") // seq param 
	public void m1(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		 System.out.println(seq);
	}
	
	@GetMapping("/param2") // seq param // seq 필수 
	public void m2(String seq) {
		System.out.println(seq);
	}
	
	@GetMapping("/param3") // seq param 
	public void m3(@RequestParam(name="seq", required=true) String seq) {
		System.out.println(seq);
	}
	
	@GetMapping("/param4") // seq param 
	public void m4(String name, int price) { // price 는 primitive type. string은 null 로 하면 되지만 price는 처리가 안된다!
		System.out.println(name);
		System.out.println(price);
		
		CarDto dto = new CarDto();
//		dto.setName(name);
		dto.setPrice(price);
		// service layer로 전달...
	}
	
	
	@GetMapping("/car1") 
	public void m5(CarDto dto, HttpServletRequest request) { // parameter 에 dto 
		System.out.println(dto);
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("Name"));	
	}
	
	@GetMapping("/map") 
	public void m6(@RequestParam Map<String, String> params) {
		System.out.println(params.get("Name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("owner"));
	}
	
	@GetMapping("/header") // header 
	public void m7(
			@RequestHeader(value="Accept") String accept,
			@RequestHeader(value="Host") String host
	
	)
	{ 
		System.out.println(accept);
		System.out.println(host);
	}
	
	@GetMapping("/session") 
	public void m8(HttpSession session, String msg) {
		System.out.println(msg);
		session.setAttribute("msg", msg); // 다양한 용도로 session 객체를활용 
	}
}
