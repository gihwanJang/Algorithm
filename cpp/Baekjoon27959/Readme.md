# (27959) 초코바
[문제 바로가기](https://www.acmicpc.net/problem/27959)
## :100: Algorithm
## 문제
밤고는 $100$원 동전을 $N$개 갖고 있고, 그 돈으로 가격이 $M$원인 초코바를 사 먹으려고 한다. 밤고는 갖고 있는 돈으로 초코바를 사 먹을 수 있는지 알고 싶어 한다.

밤고가 가진 돈이 초코바의 가격 이상이면 밤고는 초코바를 살 수 있다. 밤고가 가진 돈이 초코바를 사기에 충분한지 판단해주자. 
#
## 입력
첫 번째 줄에 두 정수 $N$과 $M$이 공백을 사이에 두고 주어진다. ($1 \le N \le 100$, $1 \le M \le 10\ 000$)
#
## 출력
밤고가 초코바를 살 수 있으면 Yes를, 없으면 No를 출력한다.
#
## 풀이
정수 n, m을 입력 받습니다.  
n * 100이 m보다 작으면 No 아니면 Yes를 출력합니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    cout << (n * 100 < m ? "No" : "Yes") << "\n";
    return 0;
}
```