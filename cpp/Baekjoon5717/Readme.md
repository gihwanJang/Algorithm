# (5717) 상근이의 친구들
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/5717)
#
## 문제
상근이의 남자 친구의 수와 여자 친구의 수가 주어졌을 때, 친구는 총 몇 명인지 구하는 프로그램을 작성하시오.
#
## 입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 두 정수 M과 F로 이루어져 있으며, 각각은 상근이의 남자 친구의 수와 여자 친구의 수이다. (1 ≤ M, F ≤ 5)

입력의 마지막 줄에는 0이 두 개 주어진다.
#
## 출력
각 테스트 케이스마다 상근이의 친구의 수를 출력한다.
#
## 풀이
각 친구의 수를 입력 받은 후 둘다 0이 아니면 합을 출력해 줍니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, f;

    while(true){
        cin >> m >> f;

        if(!m && !f)
            return 0;
        
        cout << m + f << "\n";
    } 
    return 0;
}
```