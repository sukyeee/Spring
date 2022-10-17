package com.ssafy.hello.di3;

public class HelloMessageFactory {

	public static HelloMessage getHellomessage(String lang) {
		if("kor".equals(lang)) {
			return new HelloMessageKor(); // 원래는 이것도 싱글톤으로 만들어야 ! 위 예제는 그냥 간단하게..
		} else {
			return new HelloMessageEng();
		}
	}

}
