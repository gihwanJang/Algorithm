# (5525) IOIOI
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/5525)
#
## 문제
N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.

- P1 IOI
- P2 IOIOI
- P3 IOIOIOI
- PN IOIOI...OI (O가 N개)

I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.
#
## 출력
S에 PN이 몇 군데 포함되어 있는지 출력한다.
#
## 풀이
해당 문제의 경우 2가지로 해결 할 수 있습니다.  

1. 입력 n 의 문자열을 만든후 s에 대하여 선형적으로 substring을 검색하며 카운팅하는 경우
2. 문자열 s에 대하여 선형적으로 탐색하며 "IOI"의 연속된 갯수를 카운팅하는 경우

1번의 경우 해당 인덱스마다 substring을 만들고 비교해야하므로 1번 테스크에 대하여는 통과하지만 2번 테스크에 대하여는 통과할 수 없습니다.  

그러므로 모든 테스크를 통과하기위해서는 2번 방법을 이용하여 시행해 주어야 합니다.  

```cpp
#include <iostream>

using namespace std;

int counting(int n, string s){
    int res = 0, sub = 0;

    for(int i = 0; i < s.length()-2; ++i, sub = 0)
        if(s[i] != 'O')
            for(; s[i + 1] == 'O' && s[i + 2] == 'I'; i += 2)
                if (++sub == n) {
                    --sub;
                    ++res;
                }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    string s;
    cin >> n >> m >> s;

    cout << counting(n, s) << "\n";
    return 0;
}
```