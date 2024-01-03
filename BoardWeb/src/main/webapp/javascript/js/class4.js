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
delete friend.age; // 속성을 지울 때
friend.ages = 20;
friend.showFriends = function () { // 메소드
    console.log(this); // this 객체 => friend를 가르킴
}
console.log(friend);
console.log(friend.pets[0]['friends']);