# (15680) N과 M(5)
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/15680)

## 문제
![img_1](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15680/1.png)

연세대학교의 영문명은 YONSEI, 슬로건은 Leading the Way to the Future이다.

이를 출력하는 프로그램을 작성해보도록 하자.
#
## 입력
첫째 줄에 N이 주어진다. (N = 0 또는 1)
#
## 출력
- N = 0일 경우: 연세대학교의 영문명을 출력한다.
- N = 1일 경우: 연세대학교의 슬로건을 출력한다.  
대소문자 구별에 주의하도록 하자.
#
## 풀이
3항 연산자를 이용하여 n이 0 이면 영문명을 1이면 슬로건을 출력해 주면됩니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << (n ? "Leading the Way to the Future" : "YONSEI") << "\n";
    return 0;
}
```