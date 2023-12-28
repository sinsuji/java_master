<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- getMember.jsp -->
<h3>회원상세</h3>
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${vo.id}</td>
			<td>${vo.pw}</td>
			<td>${vo.name}</td>
			<td>${vo.responsibility}</td>
		</tr>
	</tbody>
</table>