package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/studentList") // url - 확장자가 아님
public class StudentListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentListServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); // content 타입 : txt, html, json - 출력되는 콘텐츠의 타입을 설정해줌
		PrintWriter out = response.getWriter();
		
		// 목록 페이지
		StudentService dao = new StudentServiceMybatis();
		List<Student> list = dao.studentList();
		
		// out.print("<table border='1'>");
		String str = "<table border='1'>";
		str += "<thead><tr><th>학생번호</th><th>학생이름</th><th>영어점수</th><th>수학점수</th></tr></thead>";
		str += "<tbody>";
		for(Student std : list) {
			str += "<tr><td><a href='getStudentServlet?sno=" + std.getStuNo() + "'>" + std.getStuNo() + "</a></td><td>" + std.getStuName() + "</td><td>" + std.getStuEng() + "</td><td>" + std.getStuMat() + "</td></tr>";
		}
		str += "</tbody></table>";
		str += "<br><a href='student/inform.html'>등록화면</a>";
		
		out.print(str);
		
		// out.println("<a href='student/inform.html'>입력창 이동</a>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
