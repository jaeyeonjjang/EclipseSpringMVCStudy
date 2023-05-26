package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 년월일을 입력하면 요일을 알려주는 프로그램.
public class YoilTellerMVC {
    @RequestMapping("/getYoilMVC") // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1{
//    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    public ModelAndView main(int year, int month, int day) throws IOException {
	      // ModelAndView는 반환타입으로 Model을 만들지 않고 여기에 모델을 만든느거임. 근데 잘 안씀 
	    	// Model을 매개변수로 선언하면 DispatcherServlet이 모델 생성함.
    	
    		ModelAndView mv = new ModelAndView(); //Model 생성 
    		// 1. 유효성 검사
//	    	if(!isValid(year, month, day))
//	    		return "yoilError";
//	
	    	// 2. 요일 계산
	        char yoil = getYoil(year, month, day);
	
	        // 3. 계산한 결과를 model에 저장
	        mv.addObject("year",year);
	        mv.addObject("month",month);
	        mv.addObject("day",day);
	        mv.addObject("yoil",yoil);
        
//	        4. 결과를 보여줄 view의 이름을 지정
	        mv.setViewName("yoil");
	        
	        // 5. ModelAndView를 반환 
	        return mv;
//        return "yoil"; ///WEB_INF/views/yoil.jsp

    }

    //class 안에서만 쓰게하기 위해서 private로 
	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
	}
}
