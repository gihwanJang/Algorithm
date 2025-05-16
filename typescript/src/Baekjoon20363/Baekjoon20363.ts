// const fs = require("fs");
// const input: string = fs.readFileSync("/dev/stdin").toString();

export const solution = (stdinInput: string) => {
    const input: Array<string> = stdinInput.trim().split(" ");

    const max: number = Math.max(Number(input[0]), Number(input[1]));
    const min: number = Math.min(Number(input[0]), Number(input[1]));

    console.log(max + min + Math.trunc(min / 10));
};

// solution(input);