package com.mycom.myboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycom.myboard.dto.UserDto;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	// DispatcherServlet 이후 다른 Controller 의 메소드를 실행하기 직전에 호출 
	// 뭔가 테스트를 진행하고 그 결과에 따라 return true 하면 Controller 로 진행 
	// return false 하면 Controller 로 진행 X => empty response 를 Client에 보낸다.
	
	// 테스트 하려는 항목이 뭔가!! => 이곳 코드 안에서 처리/판단
	// 이걸 누구에게 적용할 것인가?? => 설정을 통해서 servlet-context.xml 에 지정 
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		
		System.out.println("LoginInterceptor : preHandle !!!");
		// #1 무조건 통과 test 
//		return true;
		
		// #2 login test
//		HttpSession session = request.getSession();
//		UserDto userDto = (UserDto) session.getAttribute("userDto");
//		
		// login 상태
		// async 에 대한 처리 미구현!!
//		if( userDto == null ) {
//			response.sendRedirect("/login");
//			return false; // 미통과  // 단지 return false 만 하면 아무런 반응이 X 없다 <= response 필요 
//		}
//		
//		return true; // 통과 // cleint가 가고자 하는 요청으로 넘어간다.

		
		// #3. page 요청과 async 요청에 대한 처리를 따로 구성
		
		// async 요청인지 확인
		String async = request.getHeader("async"); // client가 담아서 보내야 함.
		
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		if( userDto == null ) {
			// 나눠서 처리
			if("true".equals(async)) {
				// json으로 session timeout => login 이동하라는 내용을 만들어서 보낸다.
				Gson gson = new Gson();
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("result", "login");
				String jsonStr = gson.toJson(jsonObject);
				response.getWriter().write(jsonStr);
			} else {
				response.sendRedirect("/login");
			}
			
			return false; 

		}
		
		return true;
		
	}
	
}
