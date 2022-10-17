package com.mycom.myapp.calc.annotation;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		
		// Non-Spring DI
//		Calculator calc = new Calculator();
//		System.out.println(calc.add(5,6));
		
		// Spring DI 
		// Spring 환경 구성 코드 ( 마치 톰캣처럼 )
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-annotation.xml"); 
		Calculator calculator = (Calculator)context.getBean("calculator"); // 이름 <= default로 클래스 이름이 소문자로 변형되어서 나옴 
		
		//bean 요청을 하면 해당 클래스를 찾아 스프링이 객체를 만들어서 우리가 사용할 수 있게 해줌 
		
		System.out.println(calculator.add(5, 7));
		
		
		
		
	}

}
