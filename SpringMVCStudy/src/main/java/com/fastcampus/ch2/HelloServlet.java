package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns={"/hello"}, loadOnStartup=1)
	@WebServlet("/hello")
	public class HelloServlet extends HttpServlet {
		// Servlet은 기본적으로 이 3개의 메서드가 있음. 얘네들은 우리가 직접 호출하지 않고 Servlet Container가 자동으로 호출함.
		// 우리는 이 메서드의 내용만 채워주면 됨.
		@Override
		public void init() throws ServletException {  	
			// 처음에 한 번만 호출됨.
			// 서블릿이 초기화될때 자동 호출되는 메서드
			// 1. 서블릿의 초기화 작업 담당
			System.out.println("[HelloSerlvet] init() is called.");
		}
		   
		@Override // 호출될 때마다 반복적으로 수행됨.
		public void service(HttpServletRequest request, HttpServletResponse response) {
			// 1. 입력
			// 2. 처리 
			// 3. 출력
			System.out.println("[HelloSerlvet] service() is called.");
		}
	
		@Override   
		public void destroy() {   
			// 뒷정리 작업 - 서블릿이 제거(unload)될 때, 서블릿 컨테이너에 의해서 자동 호출 
			System.out.println("[HelloSerlvet] destroy() is called");  
		}
	}
	
	
	
