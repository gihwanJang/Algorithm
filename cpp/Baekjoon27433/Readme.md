# (27433) 팩토리얼 2
[문제 바로가기](https://www.acmicpc.net/problem/27433)
## :100: Algorithm
## 문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.
#
## 출력
첫째 줄에 N!을 출력한다.
#
## 풀이
정수를 입력받고 해당 정수까지 1부터 값을 곱하여 출력해 주시면 됩니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long res = 1;
    int n;
    cin >> n;

    for(int i = 1; i <= n; ++i)
        res *= i;

    cout << res << "\n";
    return 0;
}
```