// array1.js
// ary = []
const ary = [1, 2, '3', new Date()]; // 타입에 상관없이 데이터에 담을 수 있음

const numAry = [10, 20, 30, 40]
numAry.push(30);
numAry.unshift(40); // 제일 첫번째 위치에 값추가
numAry.pop(); // 마지막 요소 삭제
numAry.shift(); // 첫 요소 삭제
// numAry.splice(1, 2); // 두번째 위치에 두개를 삭제
// numAry.splice(1, 1, 50); // index 위치, 한개의 값을, 50으로 대체하겠다
// numAry.splice(1, 0, 50, 60); // 두번째 위치에 / 0 => 갯수가 0이면 / 50과 60을 추가하겠다
// numAry.splice(0); // 한번에 다 지우겠다
// numAry.length = 10; // javascript는 java와 다르게 length가 읽기속성이 아니라 length의 크기를 조정할 수 있음

const numAry2 = [50, 60];

// const numAry3 = numAry.concat(numAry2);
// numAry에 numAry2를 추가
numAry2.forEach(num => numAry.push(num));

console.log(numAry);

