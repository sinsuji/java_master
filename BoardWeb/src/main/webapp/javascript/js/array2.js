// array2.js
const numAry = [23, 10, 17, 35, 9];

let result = numAry.reduce((acc, num) => { // 함수
    // console.log(acc, num);
    return acc + num;
}, 0); // 초기값

result = numAry.reduce((acc, num) => {
    return acc > num ? acc : num;
}, 0);

// 최소값 구하기
result = numAry.reduce((acc, num) => {
    return acc < num ? acc : num;
}, numAry[0]);

console.log(`결과: ${result}`);

// 평균 구하기
result = numAry.reduce((acc, num, idx) => {
    if(idx == numAry.length - 1){
        return (acc + num) / numAry.length;
    }
    return acc + num;
}, 0)

console.log(`결과: ${result}`);

// 10보다 큰 값을 새로운 배열
result = numAry.reduce((acc, num) => {
    if(num > 10) {
        acc.push(num);
    }
    return acc;
}, []); // 초기값을 배열로 선언

console.log(`결과: ${result}`);