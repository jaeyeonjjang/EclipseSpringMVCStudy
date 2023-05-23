package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // 이건 private 이라서 외부 호출 불가.
		
		// 아까는 어떻게 호출됐냐 ? -> Reflection API를 사용 - 클래스의 정보를 얻고 다룰 수 있는 강력한 기능 제공.
		// java.lang.reflect 패키지를 제공
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // 형변환 해줘야함
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 접근(호출)가능하게 한다.
		
		main.invoke(hello); // hello.main()호출한 거랑 똑같
	}

}
