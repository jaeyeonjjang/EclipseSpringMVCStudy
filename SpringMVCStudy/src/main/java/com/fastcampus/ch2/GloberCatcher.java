package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//	@ControllerAdvice("com.fastcampus.ch2") // 패키지를 지정해줄수 있음.
//	//@ControllerAdvice // 모든 패키지에 적용됨. 컨트롤러에서 발생하는 예외들을 처리해줌.
//	public class GloberCatcher {
//		@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
//		public String catcher2(Exception ex, Model m) {
//			m.addAttribute("ex", ex);
//			return "error";
//		}
//	
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex, Model m) { //캐치블럭 메서드임. 모든 exception을 얘가 받아냄.
//		m.addAttribute("ex", ex);
//		return "error";
//	}

//}
