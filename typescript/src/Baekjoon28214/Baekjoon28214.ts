// const fs = require("fs");
// const input: string = fs.readFileSync("/dev/stdin").toString();

export const solution = (stdinInput: string) => {
    const inputRows: Array<string> = stdinInput.trim().split("\n");
    const [N, K, P]: Array<number> = inputRows[0]
            .trim()
            .split(" ")
            .map(i => Number(i));
    const bread: Array<number> = inputRows[1]
            .trim()
            .split(" ")
            .map(i => Number(i));

    let validGroupCount = 0;

    for (let i = 0; i < N; i++) {
        let nonCreamCount = 0;

        for (let j = 0; j < K; j++) {
            if (bread[i * K + j] === 0) {
                nonCreamCount++;
            }
        }

        if (nonCreamCount < P) {
            validGroupCount++;
        }
    }

    console.log(validGroupCount);
}

// solution(input);