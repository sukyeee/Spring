package com.mycom.myapp.calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseCalculator {

	// has a
	// DI Annotation 

	// #3 constructor di
	Calculator calculator;
	
	@Autowired
	public UseCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
	public int minus(int n1, int n2) {
		return calculator.minus(n1, n2);
	}
	public int mul(int n1, int n2) {
		return calculator.mul(n1, n2);
	}
	public int divide(int n1, int n2) {
		return calculator.divide(n1, n2);
	}
}
