
// 2018 KAKAO BLIND RECRUITMENT > [1차] 뉴스 클러스터링

const str1 = 'FRANCE';
const str2 = 'french';
solution(str1, str2);

function solution(str1, str2) {
    let answer;

    str1 = str1.toUpperCase();
    str2 = str2.toUpperCase();

    let arr1 = [];
    let arr2 = [];

    // 2개 글자로 나누기
    const regExp = /^[A-Z]+$/;
    let cnt = 0;
    for (let i = 0; i < str1.length; i = i + 1) {
        if (regExp.test(str1.charAt(i)) && regExp.test(str1.charAt(i + 1)))
            arr1[cnt++] = str1.charAt(i) + str1.charAt(i + 1);
    }

    cnt = 0;
    for (let i = 0; i < str2.length; i = i + 1) {
        if (regExp.test(str2.charAt(i)) && regExp.test(str2.charAt(i + 1)))
            arr2[cnt++] = str2.charAt(i) + str2.charAt(i + 1);
    }

    // 유사도
    let common = [];
    let sum = [];

    let tempArr1 = arr1.slice();
    let tempArr2 = arr2.slice();
    findCommon(tempArr1, tempArr2);

    tempArr1 = arr1.slice();
    tempArr2 = arr2.slice();
    findSum(tempArr1, tempArr2);

    if (common.length === 0 && sum.length === 0)
        answer = 65536;
    else {
        answer = (common.length / sum.length) * 65536;
        answer = Math.floor(answer);
    }

    console.log(answer);


    // 교집합
    function findCommon(tempArr1, tempArr2) {
        for (let i = 0; i < tempArr1.length; i++) {
            for (let j = 0; j < tempArr2.length; j++) {
                if (tempArr1[i] !== '-' && tempArr1[i] === tempArr2[j]) {
                    common.push(tempArr1[i]);
                    tempArr1[i] = '-';
                    tempArr2[j] = '-';
                    break;
                }
            }
        }
    }

    // 합집합
    function findSum(tempArr1, tempArr2) {
        for (let i = 0; i < tempArr1.length; i++) {
            let found = false;
            for (let j = 0; j < tempArr2.length; j++) {
                if (tempArr1[i] !== '-' && tempArr1[i] === tempArr2[j]) {
                    sum.push(tempArr1[i]);
                    tempArr1[i] = '-';
                    tempArr2[j] = '-';
                    found = true;
                    break;
                }
            }

            if (tempArr1[i] !== '-' && !found) {
                sum.push(tempArr1[i]);
                tempArr1[i] = '-';
            }
        }

        for (let i = 0; i < tempArr2.length; i++) {
            if (tempArr2[i] !== '-')
                sum.push(tempArr2[i]);
        }
    }
}













