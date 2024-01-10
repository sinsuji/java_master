<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>책목록</h3>
	<script>
		let body = document.querySelector('body');
		let tbl = document.createElement('table');
		tbl.setAttribute('border', 1);
		let thd = document.createElement('thead');
		let trh = document.createElement('tr');
		let th1 = document.createElement('th');
		th1.innerText = '도서코드';
		trh.appendChild(th1);		
		let th2 = document.createElement('th');
		th2.innerText = '도서명';
		trh.appendChild(th2);		
		let th3 = document.createElement('th');
		th3.innerText = '저자';
		trh.appendChild(th3);		
		let th4 = document.createElement('th');
		th4.innerText = '출판사';
		trh.appendChild(th4);		
		let th5 = document.createElement('th');
		th5.innerText = '가격';
		trh.appendChild(th5);		
		let th6 = document.createElement('th');
		th6.innerText = '삭제';
		trh.appendChild(th6);		
		thd.appendChild(trh);
		let tbd = document.createElement('tbody');
		let trb = document.createElement('tr');
		tbd.appendChild(trb);
		tbl.appendChild(thd);
		tbl.appendChild(tbd);
		
		body.appendChild(tbl);
		
	
		function showList(page) {
    		fetch('/bookList.do')
    		.then(str => str.json())
    		.then(result => {
    			result.forEach(book => {
    				let td = document.createElement('td');
    				trb.appendChild(td);
    			});
    		})
    		.catch(reject => console.log(reject));
    	}
	</script>
</body>
</html>