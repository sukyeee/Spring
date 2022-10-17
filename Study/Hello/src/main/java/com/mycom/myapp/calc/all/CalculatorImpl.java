package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("bbb")
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int n1, int n2) {
		System.out.println("CalculatorImpl is called");
		return n1 + n2;
	}


}
