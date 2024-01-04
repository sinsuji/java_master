// array3.js
import{ members, titles } from './data.js';

console.log(members);
console.log(titles);

let str = titles.reduce((acc, title, idx) => {
    if(idx == 0) { // 첫번째
        acc += '<tr>';
    }
    acc += '<th>' + title + '</th>';
    if(idx == titles.length - 1) { // 마지막
        acc += '</tr>';
    }
    return acc;
}, '');
console.log(str);
document.getElementById('theader').innerHTML = str; // <tr><th>...</th></tr>

const tbody = document.getElementById('tbody');
members.reduce((acc, member) => {
    let tr = document.createElement('tr');
    for(let prop in member) {
        let td = document.createElement('td');
        td.innerText = member[prop];
        tr.appendChild(td);
    }
    acc.appendChild(tr);
    return acc;
}, tbody);

// map(A -> A'), filter(A -> B) 새로운 배열을 생성해서 반환(둘다 반환값이 배열)
// map => 새로운 배열의 갯수에 변화가 없을 때 사용
let result = members.map((item, idx) => {
    let obj = {};
    obj.id = item.id;
    obj.name = item.first_name + '-' + item.last_name;
    obj.email = item.email;
    return obj;
}); 
// filter => 필터링 할 때 사용하는 메소드, 조건이 맞으면 새로운 배열을 생성해서 반환, 건수가 달라짐
result = members // 메소드 체인
    .filter(item => item.gender == 'Female')
    .map((item, idx) => {
        let obj = {};
        obj.id = item.id;
        obj.name = item.first_name + '-' + item.last_name;
        obj.email = item.email;
        return obj;
    })
    .map(item => item.name);
// result = members.filter(item => {return item.gender == 'Female'}); // 위와 동일
result.push('charles');
result.push('Hong');
result.push('charles');

console.log(result);
console.log(result.indexOf('charles', 6)); // 어떤 위치(6번째)부터 찾겠다



