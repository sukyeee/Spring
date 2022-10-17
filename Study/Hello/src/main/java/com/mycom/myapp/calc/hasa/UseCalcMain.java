package com.mycom.myapp.calc.hasa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCalcMain {

	public static void main(String[] args) {
		
		// Non-Spring DI
//		Calculator calc = new Calculator();
//		System.out.println(calc.add(5,6));
		
		// Spring DI 
		// Spring 환경 구성 코드 ( 마치 톰캣처럼 )
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("use-calc-annotation.xml");
		UseCalculator useCalculator = (UseCalculator)context.getBean("useCalculator"); // id 로 지정된 값 
		
		System.out.println(useCalculator.add(5, 7));
		
		
		
		
	}

}
