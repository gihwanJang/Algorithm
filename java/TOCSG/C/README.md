# 3. 불면증

- (영어가 조금 어려울수 있습니다. N = 1692. Now… 부분을 주의해서 보시고, 예제의 해석을 보시면 문제 이해가 쉬우실 거에요.)

## Problem

Bleatrix Trotter the sheep has devised a strategy that helps her fall asleep faster.
First, she picks a number N.
Then she starts naming N, 2 × N, 3 × N, and so on.
Whenever she names a number, she thinks about all of the digits in that number.
She keeps track of which digits (0, 1, 2, 3, 4, 5, 6, 7, 8, and 9) she has seen at least once so far as part of any number she has named.
Once she has seen each of the ten digits at least once, she will fall asleep.

Bleatrix must start with N and must always name (i + 1) × N directly after i × N.
For example, suppose that Bleatrix picks N = 1692. She would count as follows:

N = 1692. Now she has seen the digits 1, 2, 6, and 9.
2N = 3384. Now she has seen the digits 1, 2, 3, 4, 6, 8, and 9.
3N = 5076. Now she has seen all ten digits, and falls asleep.

What is the last number that she will name before falling asleep? If she will count forever, print INSOMNIA instead.

Bleatrix Trotter the sheep은 잠을 빨리 자게 할 수 있는 (divised?)전략을 가졌다.
먼저 숫자 N을 선택한다..
그리고 이름을 짖는다 N, 2 x N, 3 x N.....
숫자 작명을 할때, 모든 자릿 수를 고려한다.
각 자릿수가 적어도 한번은은 작명한 이름인지 트래킹한다.
각 자릿수가 모두 한번씩 사용 되었을 때 잠이 든다.

## Input

The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with a single integer N, the number Bleatrix has chosen.

Limits

1 ≤ T ≤ 100.

0 ≤ N ≤ 10000.

Sample

T : 5

N : [0, 1, 2, 11, 1692]

## Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last number that Bleatrix will name before falling asleep, according to the rules described in the statement.

## Input Example

5
0
1
2
11
1692

## Output Example

Case #1: INSOMNIA
Case #2: 10
Case #3: 90
Case #4: 110
Case #5: 5076

In Case #1, since 2 × 0 = 0, 3 × 0 = 0, and so on, Bleatrix will never see any digit other than 0, and so she will count forever and never fall asleep. Poor sheep!

In Case #2, Bleatrix will name 1, 2, 3, 4, 5, 6, 7, 8, 9, 10. The 0 will be the last digit needed, and so she will fall asleep after 10.

In Case #3, Bleatrix will name 2, 4, 6... and so on. She will not see the digit 9 in any number until 90, at which point she will fall asleep. By that point, she will have already seen the digits 0, 1, 2, 3, 4, 5, 6, 7, and 8, which will have appeared for the first time in the numbers 10, 10, 2, 30, 4, 50, 6, 70, and 8, respectively.

In Case #4, Bleatrix will name 11, 22, 33, 44, 55, 66, 77, 88, 99, 110 and then fall asleep.

Case #5 is the one described in the problem statement. Note that it would only show up in the Large dataset, and not in the Small dataset.
