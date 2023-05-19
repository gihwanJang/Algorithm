# (27866) 문자와 문자열
[문제 바로가기](https://www.acmicpc.net/problem/27866)
## :100: Algorithm
## 문제
단어 $S$와 정수 $i$가 주어졌을 때, $S$의 $i$번째 글자를 출력하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 영어 소문자와 대문자로만 이루어진 단어 $S$가 주어진다. 단어의 길이는 최대 $1\,000$이다.

둘째 줄에 정수 $i$가 주어진다. ($1 \le i \le \left|S\right|$)
#
## 출력
 $S$의 $i$번째 글자를 출력한다.
#
## 풀이
단어와 인덱스를 입력받고 단어에서 해당 인덱스를 출력해 주시면됩니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int idx;
    string s;
    cin >> s >> idx;

    cout << s[idx - 1] << "\n";
    return 0;
}
```