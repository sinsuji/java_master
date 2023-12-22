package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.serviceImpl.StudentServiceMybatis;
import com.yedam.student.vo.Student;

@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 기본생성자
    public MyInfoServlet() {
        super();
    }

    // 매소드 - get 방식요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) // 사용자의 요청값, 응답값을 받음
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); // content 타입 : txt, html, json - 출력되는 콘텐츠의 타입을 설정해줌
		
		// 파라미터 확인
		// ?sno=23-010&sname=황철수&escore=80&mscore=85
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");
		
		System.out.println("sno : " + sno + ", sname : " + sname + ", escore : " + escore + ", mscore : " + mscore);
		
		// db 저장
		Student std = new Student(sno, sname, Integer.parseInt(escore), Integer.parseInt(mscore));
		StudentService dao = new StudentServiceMybatis();
		boolean done = dao.addStudent(std);
		
		PrintWriter out = response.getWriter();
		// response.getWriter() => 사용자의 웹 브라우저
		// response.getWriter().append(request.getContextPath()); // 프로젝트 정보를 반환해줌
		// out.append("Served at: ").append(request.getContextPath()); // 프로젝트 정보를 반환해줌
		out.println("<h3>Welcome Servlet , 안녕하세요</h3>");
		out.println("<a href='index.html'>인덱스 이동</a>");
		
		if(done) {
			out.println("<script>alert('OK'); location.href='student/studentList.jsp'; </script>"); // studentList
		}else {
			out.println("<script>alert('Fail'); location.href='index.html'; </script>");
		}
	}

	// 매소드 - post 방식요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
