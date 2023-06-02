package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	
@WebServlet("/rollDice2")  // == @Controller+@RequestMapping // url 맵핑을 클래스 단위로 함.
// TwoDice Controller를 서블릿으로 만든거임.
// Controller는 HttpServlet 상속 안받는데 서블릿은 받아야함.
// Java는 단일상속이라 웬만하면 상속을 안받는게 좋음.
public class TwoDiceServlet extends HttpServlet {
    int getRandomInt(int range) {
	return new Random().nextInt(range)+1;
    }
    
    // main 메서 아니고 service 메서드임.
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idx1 = getRandomInt(6);
        int idx2 = getRandomInt(6);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='resources/img/dice"+idx1+".jpg'>");
        out.println("<img src='resources/img/dice"+idx2+".jpg'>");
        out.println("</body>");
        out.println("</html>");
        out.close();	    
    }
}
