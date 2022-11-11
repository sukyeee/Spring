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
		
		// CORS put, delete 요청에 대한 허락
		if( request.getMethod().equals("OPTIONS")) {
			return true;
		}
		
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		if( userDto == null ) {
			
			Gson gson = new Gson();
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("result", "login");
			String jsonStr = gson.toJson(jsonObject);
			response.getWriter().write(jsonStr);
			
			return false; 

		}
		
		return true;
		
	}
	
}
