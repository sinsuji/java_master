// class6.js
function sum(num1, num2) {
    return num1 + num2;
}

function getMax(num1, num2) {
    return num1 > num2 ? num1 : num2;
}

const friend = {
    name: "hong",
    age: 20,
    showInfo() {
        return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
    }
}

// 특정한 요소들만 반환해서 사용하겠다
export { friend, sum, getMax };