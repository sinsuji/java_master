// function5.js

// Array.prototype.forEach();
const ary = ['a', 'b', 'c'];
ary.forEach(elem => console.log(elem)); // 매개값을 받아서 화살표 구문을 실행하겠습니다
    
ary.forEach((elem, idx) => {
    if(idx > 0){
        console.log(elem);
    }
})

Array.prototype.sum = function(){ // 배열의 prototype에 메서드를 추가하여 사용할 수 있음
    console.log(this);
    let result = 0;
    this.forEach(function(val){
        result += val;
    })
    return result;
}
const numbers = [1, 2, 3, 4];
console.log('sum: ' + numbers.sum());