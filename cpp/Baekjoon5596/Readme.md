# (5596) 시험 점수
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/5596)
#
## 문제
대한고등학교에 재학 중인 민국이와 만세는 4과목(정보, 수학, 과학, 영어)에 대한 시험을 봤다. 민국이와 만세가 본 4과목의 점수를 입력하면, 민국이의 총점 S와 만세의 총점 T 중에서 큰 점수를 출력하는 프로그램을 작성하시오. 단, 서로 동점일 때는 민국이의 총점 S를 출력한다.
#
## 입력
입력은 2줄로 이루어져 있다.

1번째 줄에는 순서대로 민국이의 정보, 수학, 과학, 영어 점수(정수형)가 있으며, 공백으로 구분되어 있다.

2번째 줄에는 1번째 줄과 마찬가지로 순서대로 만세의 정보, 수학, 과학, 영어 점수(정수형)가 있고, 공백으로 구분되어 있다.
#
## 출력
문제에서 요구하는 정답을 출력한다.
#
## 풀이
각 점수를 입력 받아 합산후 만세이가 크면 만세이 총점을 아니면 민국이의 총점을 출력해 주시면 됩니다.

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum1 = 0;
    int sum2 = 0;
    int score;

    for(int i = 0; i < 4; ++i){
        cin >> score;
        sum1 += score;
    }
    for(int i = 0; i < 4; ++i){
        cin >> score;
        sum2 += score;
    }

    cout << (sum2 > sum1 ? sum2 : sum1) << "\n";
    return 0;
}

```