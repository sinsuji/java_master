<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/javascript/promise.jsp</title>
</head>
<body>

	<div id="show"></div>
	
	<script>
		let show = document.getElementById('show'); // id값으로 요소를 선택
		let cnt = 0;
		let interval = setInterval(() => {
			const today = new Date();
			let hh = today.getHours();
			let mm = today.getMinutes();
			let ss = today.getSeconds();
			cnt++;
			
			if(cnt >= 20) {
				clearInterval(interval); // 작업종료
			}
			show.innerHTML = hh + '시 ' + mm + '분 ' + ss + '초 <br>';
		}, 1000);	
	
		const promise = new Promise(function(resolve, reject) { // 첫번째 매개값: 요청의 처리가 정상적으로 처리됐을 때 받는 함수, 두번째 매개값: 실패했을 때 실행할 함수 
			setTimeout(function() { // 실행할 함수, 지연시간
				resolve('Fail');
			}, 3000);
		}); // pending(초기화) -> fullfilled(정상처리) -> rejected(비정상처리)
		promise.then(function(result) { // 정상처리 됐을 때
				console.log('then=> ', result);
				return 'ok';
			})
			.then(function(result) {
				console.log('second then=>', result);
			})
			.catch(function(err) { // 비정상처리 됐을 때
				console.error('error=> ', err);
			})
		
	</script>
</body>
</html>