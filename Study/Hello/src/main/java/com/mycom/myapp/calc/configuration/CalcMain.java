package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// java bean 클래스 이용 spring 버전이 4...
public class CalcMain {

	public static void main(String[] args) {
		
		// Non-Spring DI
//		Calculator calc = new Calculator();
//		System.out.println(calc.add(5,6));
		
		// Spring DI 
		// Spring 환경 구성 코드 ( 마치 톰캣처럼 )
		// 자바 Configuration 클래스를 이용 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		Calculator calculator = (Calculator)context.getBean("calculator"); // id 로 지정된 값 
		System.out.println(calculator.add(5, 8));
		
		
		
		
	}

}
