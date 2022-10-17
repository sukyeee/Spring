package com.mycom.myapp.calc.all;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		
		// Non-Spring DI
//		Calculator calc = new Calculator();
//		System.out.println(calc.add(5,6));
		
		// Spring DI 
		// Spring 환경 구성 코드 ( 마치 톰캣처럼 )
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("all-calc-annotation.xml");
		AllCalculator calculator = (AllCalculator)context.getBean("allCalculator"); // 이름 <= default 로 
		
		System.out.println(calculator.add(10, 3));
		System.out.println(calculator.minus(10, 3));
		System.out.println(calculator.mul(10, 3));
		System.out.println(calculator.divide(10, 3));

		
		
		
	}

}
