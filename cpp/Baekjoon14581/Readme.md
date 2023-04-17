# (14581) 팬들에게 둘러싸인 홍준
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/14581)

## 문제
홍준은 참 팬이 많다. 이를 본 구사과는 BOJ 슬랙에서 이모티콘을 만들었다.

![img](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14581/1.png)

선풍기 모양의 이모티콘은 :fan: 이고, 홍준의 이모티콘은 :(홍준의 아이디): 이다. 홍준의 아이디가 주어지면 구사과가 만든 이모티콘을 출력하는 프로그램을 작성하여라. 자세한 출력 방식은 입출력 형식을 참고하면 된다.
#
## 입력
첫 번째 줄에 홍준의 아이디를 입력받는다. 홍준의 아이디는 길이가 20 이하인 문자열이며, 알파벳 소문자, 알파벳 대문자, 숫자로만 이루어졌다.
## 출력
3개의 줄에 걸쳐, 팬들에게 둘러싸인 홍준의 모습을 출력한다.
#
## 풀이
입력 받은 문자열을 가운데에 출력해 주면 됩니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << ":fan::fan::fan:\n";
    cout << ":fan::" << s << "::fan:\n";
    cout << ":fan::fan::fan:\n";
    return 0;
}
```