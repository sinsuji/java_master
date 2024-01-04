// array4.js
// map, filter, find, indexOf, some, every

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

// 1. 콘이라는 이름이 몇번?
console.log('콘이름횟수 ' + str.split(', ').filter(name => name == '콘').length)

// 2. 이름이 3자 이상이 몇명?
console.log('3자이상횟수 ' + str.split(', ').filter(name => name.length >= 3).length)

// 3. 2자인 이름이 있는지 여부?
console.log('2자존재여부 ' + str.split(', ').some(name => name.length == 2))

// 4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입.

const strAry = str.split(', ').map((item, idx) => {
    return {
        no: idx + 1,
        name: item
    };
});
console.log(strAry)
// 1.
console.log('콘: ', strAry.reduce((acc, obj) => {
    if (obj.name == '콘') {
        acc++;
    }
    return acc;
}, 0));
// 2.
console.log('3자 이상: ', strAry.reduce((acc, obj) => {
    if (obj.name.length >= 3) {
        acc++;
    }
    return acc;
}, 0));
// 3.
console.log('2자: ' + strAry.some(obj => obj.name.length == 2));