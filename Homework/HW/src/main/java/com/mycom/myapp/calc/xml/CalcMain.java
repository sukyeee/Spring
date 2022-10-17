package com.mycom.myapp.calc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		Calculator calculator = (Calculator)context.getBean("calculator"); // id 로 지정된 값 
		
		System.out.println(calculator.add(10, 3));
		System.out.println(calculator.minus(10, 3));
		System.out.println(calculator.mul(10, 3));
		System.out.println(calculator.divide(10, 3));

	}

}
