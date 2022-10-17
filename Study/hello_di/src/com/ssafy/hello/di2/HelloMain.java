package com.ssafy.hello.di2;

public class HelloMain {

	public static void main(String[] args) {
		HelloMessageKor kor = new HelloMessageKor();
		String greet = kor.hello("안효인");
		System.out.println(greet);
	}

}
