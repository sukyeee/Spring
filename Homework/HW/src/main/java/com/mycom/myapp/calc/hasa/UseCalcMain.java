package com.mycom.myapp.calc.hasa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCalcMain {

	public static void main(String[] args) {
		
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("use-calc-annotation.xml");
		UseCalculator useCalculator = (UseCalculator)context.getBean("useCalculator"); // id 로 지정된 값 
		
		System.out.println(useCalculator.add(10, 3));
		System.out.println(useCalculator.minus(10, 3));
		System.out.println(useCalculator.mul(10, 3));
		System.out.println(useCalculator.divide(10, 3));

		
		
		
	}

}
