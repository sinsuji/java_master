// function2.js
let members = `[{"id":1,"first_name":"Druci","last_name":"Sussans","email":"dsussans0@moonfruit.com","gender":"Female","salary":1775},
{"id":2,"first_name":"Zuzana","last_name":"Whitsun","email":"zwhitsun1@washington.edu","gender":"Female","salary":8988},
{"id":3,"first_name":"Meryl","last_name":"Sculpher","email":"msculpher2@miibeian.gov.cn","gender":"Female","salary":2816},
{"id":4,"first_name":"Valeda","last_name":"Burwood","email":"vburwood3@google.com.br","gender":"Female","salary":2784},
{"id":5,"first_name":"Cort","last_name":"Tissier","email":"ctissier4@last.fm","gender":"Male","salary":8312},
{"id":6,"first_name":"Glad","last_name":"Yakobowitch","email":"gyakobowitch5@google.com.br","gender":"Female","salary":3039},
{"id":7,"first_name":"Heida","last_name":"Le Fleming","email":"hlefleming6@shutterfly.com","gender":"Female","salary":5311},
{"id":8,"first_name":"Niki","last_name":"Clem","email":"nclem7@creativecommons.org","gender":"Male","salary":647},
{"id":9,"first_name":"Cornelia","last_name":"Rushmare","email":"crushmare8@wikia.com","gender":"Female","salary":9452},
{"id":10,"first_name":"Anabal","last_name":"Dudderidge","email":"adudderidge9@exblog.jp","gender":"Female","salary":6584},
{"id":11,"first_name":"Tedie","last_name":"Lamba","email":"tlambaa@youtu.be","gender":"Male","salary":3337},
{"id":12,"first_name":"Stephanie","last_name":"Hallows","email":"shallowsb@ucoz.ru","gender":"Female","salary":7899},
{"id":13,"first_name":"Gibbie","last_name":"Ivshin","email":"givshinc@cam.ac.uk","gender":"Male","salary":6400},
{"id":14,"first_name":"Kristal","last_name":"Valance","email":"kvalanced@51.la","gender":"Female","salary":9575},
{"id":15,"first_name":"Bobbie","last_name":"McCrostie","email":"bmccrostiee@nydailynews.com","gender":"Female","salary":7276}]`;

let memberAry = JSON.parse(members); // 문자열 -> 객체변환(자바스크립트에서 쓰기 편한 객체로 변환해줌)
console.log(memberAry[14]);

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여']

function makeHeader(fields=[], pos={}){ // fields=[] 태그를 만들기 위한 데이터,  pos={} 데이터를 붙이기 위한 위치
    let tr = document.createElement('tr');
    fields.forEach(function(field){
        console.log('field : ' + field);
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}

// 위치
makeHeader(titles, document.getElementById('theader'));

function makeBody(data=[], pos={}){
    data.forEach(function(item){
        console.log(item);
        let tr = document.createElement('tr');
        if(item.gender == 'Male'){
            tr.setAttribute('style', 'background-color:aqua');
        }else if(item.gender == 'Female'){
            tr.setAttribute('style', 'background-color:pink');
        }
        for(let prop in item){
            let td = document.createElement('td');
            td.innerText = item[prop];
            tr.appendChild(td);
        }
        pos.appendChild(tr);
    }) 
}

makeBody(memberAry, document.getElementById('tbody'));