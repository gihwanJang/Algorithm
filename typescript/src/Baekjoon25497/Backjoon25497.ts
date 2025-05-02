// const fs = require("fs");
// const input: string = fs.readFileSync("/dev/stdin").toString();

export const solution = (stdinInput: string) => {
    const input: Array<string> = stdinInput.trim().split("\n");

    const n: number = Number(input[0]);
    const skils: string = input[1];

    var cnt: number = 0;
    var sCnt: number = 0;
    var lCnt: number = 0;

    for (let i = 0; i < skils.length; ++i) {
        if (skils[i] === 'R') {
            if (lCnt > 0) {
                --lCnt;
                ++cnt;
            } else {
                break;
            }
        } else if (skils[i] === 'K') {
            if (sCnt > 0) {
                --sCnt;
                ++cnt;
            } else {
                break;
            }
        } else if (skils[i] === 'L') {
            ++lCnt;
        } else if (skils[i] === 'S') {
            ++sCnt;
        } else {
            ++cnt;
        }
    }

    console.log(cnt);
}

// solution(input);