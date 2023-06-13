# (15726) 이칙연산
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/15726)
#
## 문제
다음과 같이 세 수가 연속해서 주어졌을 때 한 번의 곱셈 기호와 한 번의 나눗셈 기호를 이용하여 만든 식 중 가장 큰 값을 출력하는 프로그램을 작성하시오. (세 수의 순서는 변하지 않는다.)

32 ☐ 16 ☐ 8
#
## 입력
첫째 줄에 세 개 정수 A, B, C(1 ≤ A, B, C ≤ 1,000,000)가 주어진다. 답은 int범위를 벗어나지 않는다.
## 출력
나올 수 있는 가장 큰 값을 출력한다. 단, 소수점 아래는 버린다. 1e-9 이하의 오차로 인해 출력이 달라지는 입력은 주어지지 않는다.
#
## 풀이
3개의 수 a, b, c를 입력 받습니다.

a * b / c, a / b * c 중 큰 값을 출력합니다.

*이때 나눌 때 자료형을 double로 바꿔 주어야합니다.

```cpp
#include <algorithm>
#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long a,b,c;
    cin >> a >> b >> c;

    cout << max(int(double(a*b)/c), int(double(a)/b*c));
    return 0;
}
```