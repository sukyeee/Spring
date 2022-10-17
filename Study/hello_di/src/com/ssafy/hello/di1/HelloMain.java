package com.ssafy.hello.di1;

public class HelloMain {

	public static void main(String[] args) {
		HelloMessageKor kor = new HelloMessageKor();
		String greet = kor.helloKor("안효인");
		System.out.println(greet);
	}

}
