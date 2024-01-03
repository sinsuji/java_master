// string1.js

let str1 = "Hello"; // 문자열
console.log(str1, typeof str1);
let str2 = new String("Hello"); // 객체
console.log(str2, typeof str2);

console.log(str1 == str2); // 값만 비교하겠음 true
console.log(str1 === str2); // 타입까지 비교하겠음 false

console.log(str2.substring(1, 3)); // 앞에 값인 1은 포함하고 뒤에 값인 3은 포함하지 않겠다[인덱스 위치]
// substring의 경우 객체에서만 사용가능하지만 str1은 문자열임에도 자동형변환이 일어나 str2와 같은 결과값이 나옴

// trim 공백을 기준으로 좌우 여백을 잘라내겠다
let word = "   Hello, World  ";
console.log(word.trim());

// replace 값을 바꿀 때 사용
// const obj = {} = new Object(); {}
// const reg = new RegExp(); /값/
console.log(word.replace(/l/g, 'L')); // l을 찾아서 L로 변경하는데 전체구문에서 찾겠다(g)
console.log(word.replace('H', 'h'));
console.log(word.replace(',', '.'));
console.log(word.replace(/\s/g, '')); // \s => 공백을 다 찾아와서 빈공백으로 대체하겠다

word = '  how are you   to day  everyone.  ';
console.log(word.split(' ').filter(val => val).join(' ')); 
// split 문자열을 공백을 기준으로 잘라서 배열을 만들어줌
// filter (배열 메소드)가져온 값이 조건에 맞으면 그 값만(true인 값) 새로운 배열에 담아줌
// join (배열 메소드)배열에 담긴 값들로 새로운 문자를 만들어줌
