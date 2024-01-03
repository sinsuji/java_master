// class1.js

const obj1 = {
    name: 'hong',
    age : 20,
    showInfo() {
        return `이름은 ${this.name} 이고 나이는 ${this.age} 입니다.`;
    }
}

// 클래스 생성
class Member {
    constructor(name, age) { // 생성자
        this.name = name;
        this.age = age;
    }
    titles = ['이름', '나이'];
    showTitle() {
        this.titles.forEach(item => {
            console.log(item);
        })
        return undefined;
    }
    showInfo() {
        return `이름은 ${this.name} 이고 나이는 ${this.age} 입니다.`;
    }
}

Member.prototype.showName = function() { // prototype에 있는 기능들을 사용하여 실행하겠다
    return `이름은 ${this.name} 입니다.`;
}


const obj2 = new Member('홍길동', 20);
console.log(obj2.showName());