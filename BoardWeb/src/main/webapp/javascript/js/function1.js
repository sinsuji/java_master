// function1.js
// 함수선언식
function sum(num1 = 0, num2 = 0){ // sum(num1 = 0, num2 = 0) -> 초기값 지정, 초기값을 지정해주지 않으면 undefined가 되기 때문에 반환값이 NaN이 나옴
    let result = 0;
    result = num1 + num2;
    // console.log(result);
    console.log(arguments); // 함수가 실행되는 시점에 매개값을 받아서 처리해줌, 매개값이 몇개인지 확인 할 수 있음
    if(arguments.length > 2){
        for(let arg = 2; arg < arguments.length; arg++){
            result += arguments[arg];
        }
    }
    return result;
}

let result = sum(11, 22, 33, 44, 55, 66);
console.log('결과는 ' + result);

// 함수표현식
let sum2 = function(num1 = 0, num2 = 0){
    let result = num1 + num2;
    return result;
}
console.log('결과: ' + sum2(10, 20));

let obj1 = {
    name: "Hong",
    point: 100
}
let obj2 = {
    name: "Hwang",
    point: 80 
}
let average = function(obj1 = {}, obj2 = {}){ // 매개값이 객체타입임을 알려줌
    let result = 0;
    result = (obj1.point + obj2.point) / 2;
    return result;
}
console.log('평균값: ' + average(obj1, obj2));
let array1 = [10, 20];
let array2 = [30, 40];
let sum3 = function(ary1 = [], ary2 = []){ // 매개값이 배열
    let result = 0;
    ary1.concat(ary2).forEach(function(val){ // concat => 두 배열을 합침
        result += val;
    })
    return result;
}
console.log('배열의 총합: ' + sum3(array1, array2));

let myfunc = function(callback){ // 이름은 꼭 callback을 써야하는건 아님
    let result = 0;
    let num1 = 10, num2 = 5;
    result = callback(num1, num2);
    return result;
}

let sumfunc = function(n1, n2){
    return n1 + n2;
}

let minusfunc = function(n1, n2){
    return n1 - n2;
}

console.log('함수결과 ' + myfunc(minusfunc));