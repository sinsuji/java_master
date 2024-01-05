<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/nav.jsp"></jsp:include>

	<h3>상세화면</h3>
	
	<form name="myForm" action="modifyForm.do">
		<input type="hidden" name="bno" value="${vo.boardNo}">
	    <table class="table">
	        <tbody>
	            <tr>
	                <td>글번호</td>
	                <td colspan="3">${vo.boardNo}</td>
	            </tr>
	            <tr>
	                <td>제목</td>
	                <td colspan="3">${vo.title}</td>
	            </tr>
	            <tr>
	                <td>내용</td>
	                <td colspan="3">${vo.content}</td>
	            </tr>
	            <tr>
	                <td>작성자</td>
	                <td colspan="3">${vo.writer}</td>
	            </tr>
	            <tr>
	                <td>작성일</td>
	                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.writeDate}" /></td>
	                <td>조회수</td>
	                <td>${vo.clickCnt}</td>
	            </tr>
	            <tr>
	                <td>이미지</td>
	                <td colspan="3">
                		<c:if test="${!empty vo.image}">
                			<img src="images/${vo.image}" width="200px">
                		</c:if>
	                </td>
	            </tr>
	            <tr>
	                <td colspan="4" align="center">
	                	<c:choose>
	                		<c:when test="${logName eq vo.writer}">	                		
		                    	<input type="submit" value="수정">
		                    	<input type="button" onclick="deleteFun()" value="삭제">
	                		</c:when>
	                		<c:otherwise>
	                			<input type="submit" disabled value="수정">
		                    	<input type="button" disabled onclick="deleteFun()" value="삭제">
	                		</c:otherwise>
	                	</c:choose>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	</form> 
    <br>
    댓글내용: <input type="text" id="content"><button id="addReply">등록</button>
    <p>댓글목록</p>
    <div id="show">
    	<ul id="list">
    	</ul>
    </div>
    
    <a href="boardList.do">글목록으로</a>
    <script src="js/service.js"></script>
    
    <script>
    	function deleteFun(){
    		console.log(window);
    		document.forms.myForm.action = "removeForm.do";
    		document.forms.myForm.submit();
    	}
    	
    	const bno = '${vo.boardNo}';
    	let ul = document.querySelector('#list');
    	// Ajax호출
    	const xhtp = new XMLHttpRequest(); // 내장객체 - 비동기 방식으로 서버에 데이터를 요청하고 받아옴
    	xhtp.open('get', 'replyListJson.do?bno=' + bno); // 서버에 요청할 페이지 지정 // 요청방식, 요청페이지
    	xhtp.send()
    	xhtp.onload = function() {
    		let data = JSON.parse(xhtp.responseText); // json문자열 -> 자바스크립트의 객체로 변경
    		data.forEach(reply => {
    			let li = makeLi(reply);
    			ul.appendChild(li);
    		})
    	}
    	
    	// 등록버튼 클릭 이벤트 생성
    	// document.querySelector('#addReply').addEventListener('click', function() {});
    	document.querySelector('#addReply').onclick = function() {
    		let reply = document.querySelector('#content').value;
    		let replyer = '${logId}';
    		
    		const addAjax = new XMLHttpRequest();
    		addAjax.open('get', 'addReplyJson.do?reply=' + reply + '&replyer=' + replyer + '&bno=' + bno);
    		addAjax.send();
    		addAjax.onload = function() {
    			let result = JSON.parse(addAjax.responseText);
    			if(result.retCode == 'OK'){
    				let reply = result.vo;		
    				let li = makeLi(reply);
	    			ul.appendChild(li);
	    			
	    			document.querySelector('#content').value = '';
    			} else if(result.retCode == 'NG'){
    				alert('처리중 에러');
    			}
    		}
    		console.log(reply, replyer);
    	}
    </script>
    
<jsp:include page="../layout/foot.jsp"></jsp:include>