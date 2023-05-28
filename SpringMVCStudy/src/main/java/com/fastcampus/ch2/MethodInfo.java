package com.fastcampus.ch2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{
		
		// 1.YoilTeller클래스의 객체를 생성
		Class clazz = Class.forName("com.fastcampus.ch2.YoilTeller");
		Object obj = clazz.newInstance();
		
		// 2. 모든 메서 정보를 가져와서 배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method m : methodArr) {
			String name = m.getName(); // 메서드의 이름
			Parameter[] paramArr = m.getParameters(); // 메개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType(); // 반환 타입
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")"); // 구분자, 접두사, 접미사
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}

/* [실행결과]
 * void main(javax.servlet.http.HttpServletRequest arg0, javax.servlet.http.HttpServletResponse arg1)
 * 컴파일 할 때 매개변수 타입만 중요하지 이름은 중요하지 않아서 arg0 이런식으로 나옴.
 * 매개변수 이름을 저장하려면 컴파일 옵션에 -parameters라고 컴파일 옵션을 줘야함. 이게 매개변수이름 저장옵션임. jdk1.8(java8) 이후부터 추가됨.
java.lang.String main(java.lang.String year, java.lang.String month, java.lang.String day, org.springframework.ui.Model model)
boolean isValid(int year, int month, int day)
*/


