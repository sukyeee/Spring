package com.mycom.myapp.calc.hasa;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public int add(int n1, int n2) {
		return n1 + n2;
	}
	public int minus(int n1, int n2) {
		return n1 - n2;
	}
	public int divide(int n1, int n2) {
		return n1 / n2;
	}
	public int mul(int n1, int n2) {
		return n1 * n2;
	}
}
