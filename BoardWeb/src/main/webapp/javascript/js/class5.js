// class5.js
// Map, Set
const map = new Map();
map.set('홍길동', 20); // key : value
map.set('김민수', 22);
map.set('최성우', 25);
map.set('홍길동', 21); // 똑같은 key에 해당하는 내용이 있으면 새로운 값으로 변경됨

map.delete('최성우');
// map.clear(); // 모든 요소들을 삭제

console.log(map.get('김민수'));

for(let key of map.keys()){
    console.log(`key는 ${key}, value는 ${map.get(key)}`);
}

console.log(map.keys()); // key값 반환, 해당되는 key값을 새로운 컬렉션에 담아줌
console.log(map.values()); // value값 반환

for(let obj of map.entries()){
    console.log(obj); // 배열처럼 값을 가져옴
}

for(let [item, value] of map.entries()){ // item과 value를 따로 구분하고 싶을 때
    console.log(item, value); 
}
// 첫번째 매개값이 값, 두번째 매개값이 키
map.forEach((val, key) => console.log('key: ' + key + ', val: ' + val));

console.log(map.entries()); // key값과 value값 각각 반환

// Set
const set = new Set();
set.add('홍길동');
set.add('김민수');
set.add('홍성길');
set.add('홍길동'); // 중복된 값은 제거해서 나옴

set.delete('김민수');

console.clear(); // 이전에 만들었던 console들을 clear 해줌
console.log(set.size);

set.forEach(name => console.log(name));

const numAry = [10, 14, 12, 10];
const num = new Set(numAry); // 배열을 set 컬렉션으로 변경
num.forEach(number => console.log(number));

map.clear();

map.set('김명철', 80);
map.set('김익수', 70);
map.set('이명철', 80);
map.set('이익수', 85);
map.set('홍길동', 80);
// 김씨 점수의 합계

let sum = 0;
map.forEach((score, name) => {
    if(name.indexOf('김') == 0){ // 첫번째 값이 0
        sum += score;
    }
    // if(name.indexOf('김') != -1){
    //     sum += score;
    // }
})

console.log(`합계: ${sum}`);