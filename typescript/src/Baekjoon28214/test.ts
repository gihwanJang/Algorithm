import { solution } from "./Baekjoon28214"

const inputs: Array<string> = [
`
2 3 2
1 1 0 1 0 0
`,
`
3 2 1
1 1 0 0 1 1
`,
`
2 3 2
1 1 1 0 0 0
`
];

for (const input of inputs) {
    console.log(`*****************input*****************`)
    console.log(input)
    console.log(`*****************output*****************`)
    solution(input);
}