package com.mystudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sungjuk") //html파일과 이어주기
public class Ex05 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//실습 전달받은 데이터를 연산처리 후 결과를 응답처리
		//1. 전달받은 데이터(파라미터) 값 추출(확인)
		//2. 계산처리 -총점, 평균
		//3. 응답처리(출력)-브라우저(사용자)쪽으로 HTML태그 작성
		
		System.out.println("> Ex05.doGet() 실행");
		
		String name = req.getParameter("name");
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int math = Integer.parseInt(req.getParameter("math"));
		
		int total = kor+eng+math;
		double avg_1 = total / 3.0;
		String formatted = String.format("%.2f", avg_1);
//		double avg_2 = Math.round(avg_1); // 소수 첫째자리를 정수로 반올림
//		double avg = total * 100 / 3 / 100.0; 
		
		//=====================
		//클라이언트(브라우저) 쪽으로 응답 처리
		//응답데이터 한글 깨짐 방지를 위한 문자셋 설정
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter(); //이 코드에 대해서 좀더 자세히 알아보기.(숙제)
		out.println("<h3>성적처리 결과</h3>");
		out.println("<table border>");
		out.println("<tr>");
		out.println("<th>이름</th>");
		out.println("<th>" + name + "</th>");
		out.println("</tr>");
		out.println("<th>국어</th>");
		out.println("<th>" + kor + "</th>");
		out.println("</tr>");
		out.println("<th>영어</th>");
		out.println("<th>" + eng + "</th>");
		out.println("</tr>");
		out.println("<th>수학</th>");
		out.println("<th>" + math + "</th>");
		out.println("</tr>");
		out.println("<th>총점</th>");
		out.println("<th>" + total + "</th>");
		out.println("</tr>");
		out.println("<th>평균</th>");
		out.println("<th>" + formatted + "</th>");
		out.println("</tr>");
		out.println("</table>");
			
		
	}
}
