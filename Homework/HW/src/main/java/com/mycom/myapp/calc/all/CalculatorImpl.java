package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("cal1")
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int n1, int n2) {
		System.out.println("CalculatorImpl-add is called");
		return n1 + n2;
	}

	@Override
	public int minus(int n1, int n2) {
		System.out.println("CalculatorImpl-minus is called");
		return n1 - n2;
	}

	@Override
	public int divide(int n1, int n2) {
		System.out.println("CalculatorImpl-divide is called");
		return n1 / n2;
	}

	@Override
	public int mul(int n1, int n2) {
		System.out.println("CalculatorImpl-mul is called");
		return n1 * n2;
	}


}
