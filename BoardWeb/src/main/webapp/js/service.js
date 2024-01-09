/**
 * service.js 
 */

 function makeLi(reply = {}) {
	 // start
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '글번호: ' + reply.replyNo;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' ' + reply.reply;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' ' + reply.name;
	li.appendChild(span);
	
	// 삭제버튼
	let btn = document.createElement('button');
	btn.addEventListener('click', async function() { // btn.onclick = async function() {}
		// 댓글번호 삭제 후 화면에서 제거
		const promise = await fetch('delReplyJson.do?rno=' + reply.replyNo);
		const json = await promise.json();
		try{
			if(json.retCode == 'OK'){
				alert('삭제됨');
				showList(pageInfo);
			} else if(result.retCode == 'NG'){
				alert('처리중 에러');
			}
		} catch(err) {
			console.error('예외=>', err)
		}
			
		
		/*let delHtp = new XMLHttpRequest();
		delHtp.open('get', 'delReplyJson.do?rno=' + reply.replyNo)
		delHtp.send()
		delHtp.onload = function() {
			let result = JSON.parse(delHtp.responseText); // json문자열 -> 자바스크립트의 객체로 변경
			if(result.retCode == 'OK'){
				alert('삭제됨');
				// btn.parentElement.remove();
				// bno, page => 페이지리스트, 페이징리스트
				showList(pageInfo);
				
			} else if(result.retCode == 'NG'){
				alert('처리중 에러');
			}
		}*/
	})
	btn.innerText = '삭제';
	btn.setAttribute('style', 'margin-left:10px');
	li.appendChild(btn); // end
	
	return li;
 }