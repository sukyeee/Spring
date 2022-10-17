package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// java bean 클래스 이용 spring 버전이 4...
public class CalcMain {

	public static void main(String[] args) {
		

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		Calculator calculator = (Calculator)context.getBean("calculator"); // id 로 지정된 값 
		System.out.println(calculator.add(10, 3));
		System.out.println(calculator.minus(10, 3));
		System.out.println(calculator.mul(10, 3));
		System.out.println(calculator.divide(10, 3));

		
	}

}
