import { solution } from "./Baekjoon20363"

const inputs: Array<string> = [
`10 10`,
`123456 12345`
];

for (const input of inputs) {
    console.log(`*****************input*****************`)
    console.log(input)
    console.log(`*****************output*****************`)
    solution(input);
}