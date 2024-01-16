// book.js

// 페이지 오픈되면서 데이터를 목록에 출력 
fetch('data1.json', {
    method:'get', // get => hedaer쪽에 정보를 담음, body가 있으면 안됨
    
    // method: 'post', 의 경우는 body쪽에 정보를 담음
    // headers:{
    //     'Content-Type':'application/x-www-form-urlencode'
    // },
    // body: 'bcode=B010&bname=홍길동&bauthor=우리출판사'
    // body: 'bcode=' + bcode + '&bname=' + name + '&bauthor = 우리출판사'
})
.then(result => result.json()) // json문자값 => 자바스크립트 객체로 바꾸는 작업
.then(data => {
    console.log(data);
    data.forEach(book => {
        document.querySelector('tbody').appendChild(makeTr(book));
    })
})
.catch(err => console.log(err));


// 선택삭제
document.querySelector('#delSeleted').addEventListener('click', function() {
   // 대상
    let target = document.querySelectorAll('td input[type="checkbox"]:checked')
    target.forEach(chk => {
        chk.parentElement.parentElement.remove();
    })     
    console.log(target);
});
    // id값으로 요소선택
    document.querySelector('#saveBtn').addEventListener('click', function() {
    const bcode = document.querySelector('input[name="bcode"]').value;
    const bname = document.querySelector('input[name="bname"]').value;
    const bauthor = document.querySelector('input[name="bauthor"]').value;
    const bpress = document.querySelector('input[name="bpress"]').value;
    const bprice = document.querySelector('input[name="bprice"]').value;

    console.log(bcode, bname, bauthor, bpress, bprice);
    const userVal = {bcode, bname, bauthor, bpress, bprice}

    // tr생성 원래 있었던 부분
    let tr = makeTr(userVal); // 만들어진 tr 하나를 반환해줌

    console.log(tr);
    document.querySelector('tbody').appendChild(tr);
})


// tr생성함수
function makeTr(val={}) {
    // tr생성 >  td * 6
    const fieldAry = ['bcode', 'bname', 'bauthor', 'bpress', 'bprice']
    
    let tr = document.createElement('tr');

    // checkbox
    let td = document.createElement('td');
    let inp = document.createElement('input');
    inp.setAttribute('type', 'checkbox');
    td.appendChild(inp);
    tr.appendChild(td);

    fieldAry.forEach(field => {
        let td = document.createElement('td');
        td.innerText = val[field];
        tr.appendChild(td);
    });

    // 삭제버튼
    td = document.createElement('td');
    let btn = document.createElement('button');
    btn.innerText = '삭제';
    btn.addEventListener('click', function() {
        this.parentElement.parentElement.remove();
    });
    td.appendChild(btn);
    tr.appendChild(td);

    return tr; // 생성한 tr 반환
}