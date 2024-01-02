// function3.js
// 객체생성: {}
let obj1 = {
    name: "홍길동",
    age: 20,
    showInfo: function(){
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}

// 계속 중복된 값을 선언해줘야함
let obj2 = {
    name: "홍길동",
    age: 20,
    showInfo: function(){
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}

console.log(obj1.name);
console.log(obj1['age']);
console.log(obj1.showInfo());

// 함수를 통해 객체선언
function Member(name, age){ // 생성자 함수 => 인스턴스를 만들어준다 / 함수를 선언해서 변수를 담겠습니다 let Member = function Member(name, age) 와 같은 말
    this.name = name; // thist => new로 만들어진 인스턴스
    this.age = age;
    this.showInfo = function(){
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}

let obj3 = new Member("김명철", 22); // 객체를 하나 만들겠다, 참조값을 넣겠다.
let obj4 = new Member("이형섭", 25);
console.log(obj3.showInfo());
console.log(obj4.showInfo());