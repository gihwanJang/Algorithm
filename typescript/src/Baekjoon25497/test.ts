import { solution } from "./Backjoon25497"

const inputs: Array<string> = [
`
5
S12K2
`,
`
4
1LKR
`,
`
4
SSKK
`
];

for (const input of inputs) {
    console.log(`*****************input*****************`)
    console.log(input)
    console.log(`*****************output*****************`)
    solution(input);
}