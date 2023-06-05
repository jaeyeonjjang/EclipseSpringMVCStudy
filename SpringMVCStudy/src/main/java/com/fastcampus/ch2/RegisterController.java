package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	// RequestMapping을 간단하게 사용하게 해주는게 GetMapping과 PostMapping이다.
//	@RequestMapping("/register/add") // 아래와 같음.
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm/jsp
//	}
	
//	@RequestMapping("register/save", method=RequestMethod.POST) // 아래와 같음
	@PostMapping("/register/save") // 스프링 4.3부터 가능
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg",msg);
			return "redirect:/register/add"; // 이 두줄과 밑은 같다.
//			return "redirect:/register/add?msg="+msg;  // URL재작성 (rewriting)
		}
		// 2. DB에 신규회원 정보를 저장 
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
