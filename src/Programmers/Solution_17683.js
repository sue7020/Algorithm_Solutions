
// 2018 KAKAO BLIND RECRUITMENT > [3차] 방금그곡
// 채점 결과
// 정확성: 76.7
// 합계: 76.7 / 100.0

// const m = 'ABCDEFG';
// const musicinfos = ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"];
// const m = "CC#BCC#BCC#BCC#B";
// const musicinfos = ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"];
const m = "ABC";
const musicinfos = ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"];


let answer = "";

class Music {
    constructor(startTime, endTime, title, note) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.note = note;
    }
}


let musicArr = [];

for(let i=0; i<musicinfos.length; i++) {
    let arr = musicinfos[i].split(',');
    musicArr.push(new Music(arr[0], arr[1], arr[2], arr[3]));
}

function getDuration(startTime, endTime) {
    let start = startTime.split(':');
    let startHH = start[0];
    let startMM = start[1];

    let end = endTime.split(':');
    let endHH = end[0];
    let endMM = end[1];

    return (endHH*60 + endMM) - (startHH*60 + startMM);
}

let answerList = [];

for(let i=0; i<musicArr.length; i++) {

    const startTime = musicArr[i].startTime;
    const endTime = musicArr[i].endTime;
    const title = musicArr[i].title;
    let note = musicArr[i].note;
    const duration = getDuration(startTime, endTime);
    console.log('dur ' + duration);

    if(note.length < duration)
    {
        while(note.length < duration)
            note = note.concat(note);

        if(note.includes(m)) {
            console.log('yes')
            console.log(note);
            console.log(note.indexOf(m));
            console.log(note.charAt(note.indexOf(m) + m.length))
            if((note.indexOf(m) > 0 &&  note.charAt(note.indexOf(m) -1) === '#')
                || (note.indexOf(m) +m.length  < note.length-1 &&
                 note.charAt(note.indexOf(m) + m.length) === '#'))
                continue;
            else
                answerList.push(musicArr[i]);
        }
    }
    else {
        if(note.includes(m)) {
            answerList.push(musicArr[i]);
        }
    }



    console.log(answerList);
}

if(answerList.length === 0)
    answer = "(None)";
else if(answerList.length === 1)
    answer = answerList[0].title;
else {
    let max = answerList[0];
    for(let i=1; i<answerList.length; i++) {
        if(getDuration(max.startTime, max.endTime) < getDuration(answerList[i].startTime, answerList[i].endTime))
            max = answerList[i];
    }
    answer = max.title;
}

console.log(answer);





