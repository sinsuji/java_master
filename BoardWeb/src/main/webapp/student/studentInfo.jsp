<%@page import="common.*"%> <!-- common 안에 있는 모든 것들을 import 하겠다 -->
<%@page import="common.Student"%>
<%@page import="common.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentInfo.jsp</title>
</head>
<body>
	<%
		String str = "Hello";
		// 내장객체 : request - 이미 가지고 있는 객체
		String sno = request.getParameter("sno"); // 파라미터 값을 읽어와서 담겨있는 값을 반환하겠음
		StudentDAO dao = new StudentDAO();
		Student std = dao.getStudent(sno);
	%>
	
	<table border='1'>
		<caption>학생정보</caption>
		<tr>
			<th>학생번호</th><td><%=std.getStuNo() %></td>
		</tr>
		<tr>
			<th>학생이름</th><td><%=std.getStuName() %></td>
		</tr>
		<tr>
			<th>영어점수</th><td><%=std.getStuEng() %></td>
		</tr>
		<tr>
			<th>수학점수</th><td><%=std.getStuMat() %></td>
		</tr>
	</table>
</body>
</html>