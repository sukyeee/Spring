package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AllCalculator {

	@Autowired
	@Qualifier("cal2")
	Calculator calculator; // interface , -di 주입은 interface 를 구현한 객체 
	
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
