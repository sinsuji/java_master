// function6.js
const args = [4, 5, 6];

// 펼침연산자 - 함수의 매개변수로 쓰겠다, 배열의 값을 펼쳐서 매개값으로 쓰겠다
// 나머지파라메타 - 펼침연산자를 사용, 제일 마지막에만 사용가능
// ...args : 매개변수의 갯수가 몇개인지는 모르겠지만 들어온 갯수만큼 연산하겠다
function sum(num1 = 0, num2 = 0, ...args){
    let result = 0;
    result = num1 + num2;
    if(args.length > 0){
        args.forEach(val => {
            result += val;
        })
    }
    return result;
}

console.log(sum(10, 20, ...args)); //  ...args => 4, 5, 6과 동일

const ary1 = [10, 20];

const ary2 = ary1.concat(args);
console.log(ary2);

const ary3 = [...ary1, ...args];
console.log(ary3);

const obj1 = {name: 'Hong', age: 20};
const obj2 = {name: 'Hwang', height: 170};

// 중복된 값(같은 속성)은 뒤에 값으로 변경됨
const obj3 = {...obj1, ...obj2};
console.log(obj3);

let result = [4, 5, 6].reduce((acc, curItem, idx, ary) => { // 누산값(누적), 현재값, 인덱스, 배열 그 자체
    console.log(acc, curItem, idx);
    return acc + curItem;
}, 0);
console.log('결과값 : ' + result); // 마지막 값이 출력

// 고차함수 => 함수를 매개값으로 받는 함수 ex) reduce, forEach

// map 메소드(배열에 쓸 수 있는 메소드) // mapping기능구현
result = [1, 2, 3, 4].map((item, idx, ary) => {
    console.log(item, idx, ary);
    return item * 2;
}); 
console.log('결과값 : ', result);

// 변수의 스코프 
let name = '어피치'; // 전역변수 - 모든 영역에서 다 사용할 수 있는 변수
function run(){
    let name;
    if(true){
        name = '라이언'; //지역변수, let name일 경우, let으로 선언된 변수는 블록 안에서만 사용 가능
    }
    console.log(name);
    return name;
}
run();
console.log(name);

// 스코프 체인 
var a = 1;
var b = 5;
function outerFunc(){
    var b; // undefined
    function innerFunc(){ // outerFunc 안에서만 사용 가능
        a = b;
    }
    console.log(a); // 1
    a = 3;
    b = 4;
    innerFunc();
    console.log(a, b); // 4, 4
    var b = 2;
    console.log(b); // 2
}
outerFunc();

const c = 10;

try{
    c = 20;
} catch(error){
    console.log(error);
} finally{ // error가 나든 안나든 무조건 한번은 실행
    console.log(c);
}