// array5.js

const ary = [12, 20, 2, 1, 100, 88];
// 원하는 순으로 정렬하겠음
ary.sort((a, b) => { // a, b => 순서
    // 오름차순: -1, 내림차순 : 1
    if(a < b){
        return -1;
    } else{
        return 1;
    }
}); 
console.log(ary);

const friends = [
    {name: "Hong", age: 12},
    {name: "Hwang", age: 111},
    {name: "Park", age: 2},
    {name: "Kim", age: 33}
]

console.log("Hong" > "Park");
// 나이순으로 정렬
friends.sort((a, b) => { // 첫번째 값, 두번째 값
    if(a.age < b.age){
        return -1; // -1 값이 나오는 순대로 정렬
    } else{
        return 1;
    }
})
console.log(friends);

// 이름의 가나다 순으로도 정렬 가능
// friends.sort((a, b) => {
//     if(a.name < b.name){
//         return -1;
//     } else{
//         return 1;
//     }
// })