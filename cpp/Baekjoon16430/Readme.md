# (16430) 제리와 톰
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/16430)
#
## 문제
톰은 마트에서 치즈 1kg 을 사서 집으로 돌아왔습니다.

그런데 톰이 한눈을 판 사이 제리가 와서 A/B kg 만큼 훔쳐갔습니다.

제리가 치즈를 훔쳐 간 후 톰이 가지고 있는 치즈의 무게는 얼마인가요?
#
## 입력
첫 번째 줄에 두 정수 A, B (1 ≤ A < B ≤ 9) 가 주어집니다. 

A와 B는 서로소임이 보장됩니다.
#
## 출력
정답을 기약분수로 표현했을 때 P/Q kg 이라면 첫 번째 줄에 P와 Q를 공백을 사이에 두고 출력합니다. 
#
## 풀이
기약 분수가 장담되므로 b는 분모가 되고 남은 분자의 값은 b-a가 됩니다.  

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double a, b;
    cin >> a >> b;

    cout << b-a << " " << b << "\n";
    return 0;
}
```