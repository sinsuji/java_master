<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request.jsp</title>
</head>
<body>
	<!-- get 방식 - 단순한 데이터 -->
	<a href="ReqServ?name=kim&age=20">도서</a>
	
	<!-- post 방식(form태그를 사용해야함) - 크기제한 없음 -->
	<form action="ReqServ" method="post">
		<input type="hidden" name="name" value="kim">
		<input type="hidden" name="age" value="20">
		<button>전송</button>
	</form>
</body>
</html>