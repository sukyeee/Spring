package com.mycom.myapp.calc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		
		// Non-Spring DI
//		Calculator calc = new Calculator();
//		System.out.println(calc.add(5,6));
		
		// Spring DI 
		// Spring 환경 구성 코드 ( 마치 톰캣처럼 )
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		Calculator calculator = (Calculator)context.getBean("calculator"); // id 로 지정된 값 
		
		System.out.println(calculator.add(5, 7));
		
		
		
		
	}

}
