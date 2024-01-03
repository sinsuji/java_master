// class3.js
const ary = []
ary.push(1) // push => 값을 추가하겠다
ary.push(2)
ary.push(3)
console.log(ary.find(item => { // find => 해당되는 위치에 그 값이 있으면 값을 반환하겠다
    return item >= 2; // true값의 조건을 만족하는 첫번째 요소를 반환 (3도 조건에 해당되지만 첫번째 요소만 반환)
}))

class Estimate {
    constructor(param){
        this.unit = param;
    }
    
    // 견적가 얻기 메서드
    getEstimate(unittype, width, height){
        let priceinfo = this.unit.find(item => item.type == unittype);
        return priceinfo.price * width * height;
    }
    // 배열에 요소 추가 메서드
    addUnit(unit){
        unit.push(unit);
    }
}

let unitinfo = [{type: "wood", price: 100}, {type: "iron", price: 300}, {type: "plast", price: 200}];
const estimator = new Estimate(unitinfo);
let result = estimator.getEstimate('wood', 20, 20);
console.log(result);

// 1. 객체: this는 객체자신
// 2. function() this는 전역객체(window);
function myFunc() {
    console.log(this);
}
myFunc();

let obj = {}
obj.act = function () {
    this.value = 'default value';

    function innerAct() {
        this.value = 'innerAct value'; // 전역변수 (window)
        console.log("this.value: " + this.value);
    }

    function innerReact(caller) {
        caller.value = "innerReact value"; // obj의 value
        console.log("this.value: " + this.value); // window가 가지고 있는 value
        console.log("caller.value: " + caller.value);
    }
    innerAct();
    console.log("obj 객체의 this.value: " + this.value);
    
    innerReact(this);
    console.log("obj 객체의 this.value: " + this.value); // obj의 value
}

obj.act();

// window.location.href = "https://www.daum.net";
// 클로저
function outerFunc(name) {
    let saying = name + ' 안녕!';
    
    return function () {
        return saying;
    }
}

const closure1 = outerFunc('라이언');
const closure2 = outerFunc('콘');
console.log(closure1());
console.log(closure2());

function getCounter() {
    let cnt = 1;

    return function() {
        cnt++;
        console.log(cnt);
    }
    // increaseCounter();
}
const clo1 = getCounter();
clo1();
clo1();
clo1();