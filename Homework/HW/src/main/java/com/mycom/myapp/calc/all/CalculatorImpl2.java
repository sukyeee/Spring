package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("cal2")
public class CalculatorImpl2 implements Calculator {

	@Override
	public int add(int n1, int n2) {
		System.out.println("CalculatorImpl2-add is called");
		return n1 + n2;
	}

	@Override
	public int minus(int n1, int n2) {
		System.out.println("CalculatorImpl2-minus is called");
		return n1 - n2;
	}

	@Override
	public int divide(int n1, int n2) {
		System.out.println("CalculatorImpl2-divide is called");
		return n1 / n2;
	}

	@Override
	public int mul(int n1, int n2) {
		System.out.println("CalculatorImpl2-mul is called");
		return n1 * n2;
	}


}
