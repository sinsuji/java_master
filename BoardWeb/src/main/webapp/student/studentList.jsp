<!-- @지시자 -->
<%@ page import="common.Student"%>
<%@ page import="java.util.List"%>
<%@ page import="common.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList.jsp</title>
</head>
<body>

	<table border='1'>
		<thead>
			<tr><th>학번</th><th>이름</th><th>영어</th><th>수학</th></tr>
		</thead>
		<tbody>
		<%
			StudentDAO dao = new StudentDAO(); // 끝부분에다가 ctl + space -> import
			List<Student> list = dao.getStudentList();
			
			for (Student std : list){
		%>
			<tr>
				<td><a href="studentInfo.jsp?sno=<%=std.getStuNo() %>"><%=std.getStuNo() %></a></td> <!-- 변수의 값을 읽어오겠습니다 -->
				<td><%=std.getStuName() %></td>
				<td><%=std.getStuEng() %></td>
				<td><%=std.getStuMat() %></td>
			</tr>
		<%		
			}
		%>
		</tbody>
	</table>

	<p>바뀐값이 적용이 됩니다.</p>
</body>
</html>