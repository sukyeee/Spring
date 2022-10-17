package com.mycom.myapp.calc.annotation;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-annotation.xml"); 
		Calculator calculator = (Calculator)context.getBean("calculator"); // 이름 <= default로 클래스 이름이 소문자로 변형되어서 나옴 
		
		//bean 요청을 하면 해당 클래스를 찾아 스프링이 객체를 만들어서 우리가 사용할 수 있게 해줌 
		
		System.out.println(calculator.add(10, 3));
		System.out.println(calculator.minus(10, 3));
		System.out.println(calculator.mul(10, 3));
		System.out.println(calculator.divide(10, 3));

		
		
		
	}

}
