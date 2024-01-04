// class4.js
// ctrl + k, ctrl + f => 정렬

const friend = {
    name: "홍길동",
    age: 20,
    hobbies: ['독서', '운동', '영화'],
    pets: [{
        name: '야옹이',
        gender: 'M', 
        friends: ['검양이', '빨양이']
    }, {
        name: '멍멍이',
        gender: 'F'
    }],
    showHobby() {
        return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
    }
}
friend.pets[0]['friends'][2] = '노량이';
// delete friend.age; // 속성을 지울 때
friend.ages = 20; // 속성추가
friend.showFriends = function () { // 메소드
    console.log(this); // this 객체 => friend를 가르킴
}
console.log(friend);
console.log(friend.pets[0]['friends']);

// 참조값을 복사(동일한 객체)
const fcopy = friend; // friend라는 주소값을 담아준다
fcopy.age = 22;
console.log(fcopy);

// 객체를 복사(새로운 객체를 만듬)
const fcopy2 = Object.assign({bloodType:'0'}, friend); // 정적메소드 // assign => 객체를 복사하겠다 // 빈값에다 friend를 복사해서 담겠다
fcopy2.age = 24;
console.log(fcopy2);

// 속성추가
Object.defineProperty(friend, 'height', { // 어떤 객체에다가 속성을 추가하겠다
    get: function() { // 값을 불러오겠다
        return this._height; // this => 자기자신
    },
    set: function(value) { // 값을 담겠다
        if(value <= 0){
            alert('error');
        } else{
            this._height = value; // _ 숨김속성 => error를 방지하기 위해 // _를 붙이지 않으면 자기 값을 계속 불러오기 때문에 메모리 초과로 에러가 실행됨
        }
    }
});

friend.height = -162; 
console.log(friend.height); // getter가 없으면 값을 담을수는 있지만 불러올 수는 없음