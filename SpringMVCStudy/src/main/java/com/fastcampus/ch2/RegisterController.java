package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@InitBinder
	public void toDate(WebDataBinder binder) { // 데이트타입을 바꿔줌.
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // 이게 없으면 원래 스프링이 가지고있는 디폴트 변환기 사용함.
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));//false는 빈 값을 허용할거나안할거냐
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#")); // #을 구분자로 해서 나눔.
	}
	
	@RequestMapping(value="/register/add", method={RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm/jsp
	}
	
//	@RequestMapping("register/save", method=RequestMethod.POST) // 아래와 같음
	@PostMapping("/register/save") // 스프링 4.3부터 가능
	public String save(User user, BindingResult result, Model m) throws Exception {
		System.out.println("result=" + result);
		System.out.println("user=" + user);
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
