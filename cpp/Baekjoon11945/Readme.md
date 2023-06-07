# (11945) 뜨거운 붕어빵
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/11945)
#
## 문제
고려대학교에 입학한 새내기 호돌이는 안암역을 지나다가 한 붕어빵 장수를 만났어요.

“안녕, 안녕, 안녕하십니까, 아저씨! 붕어빵 두 개 주세요.”

“안녕을 세 번 외쳤으니 붕어빵 세 개!”

붕어빵 두 개의 값을 내고 세 개를 받은 호돌이는 기분이 좋았어요. 호돌이가 붕어빵 하나를 꺼내어 한 입 물었는데…. 너무 뜨거워서 그만 붕어빵을 떨어뜨리고 말았어요ㅠㅠ

![img](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11945/1.png)

붕어빵은 자유 낙하운동을 하면서 땅에 떨어졌는데 신기하게도 좌우가 뒤집힌 모양으로 착지했답니다. 호돌이가 붕어빵을 한 입 물기 전의 모양이 입력으로 주어지면, 땅에 떨어졌을 때에는 어떤 모양일지 출력하세요.
#
## 입력
첫째 줄에는 두 개의 정수 N과 M(0≤N,M≤10)이 주어집니다. 둘째 줄부터 N개의 줄에 걸쳐 붕어빵의 모양이 주어집니다. 각 행에는 공백을 나타내는 ‘0‘ 또는 붕어빵을 나타내는 ‘1’이 총 M개 주어집니다. 
## 출력
입력으로 주어진 붕어빵이 좌우로 뒤집힌 모양을 출력하세요.
#
## 풀이
가로 세로의 값을 입력 받은 후 세로의 길이 만큼 문자열을 입력 받습니다.

이때 입력 받은 문자열을 뒤집어 출력해주시면 됩니다.

```cpp
#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    string s;
    while(n--){
        cin >> s;
        reverse(s.begin(), s.end());
        cout << s << "\n";
    }
    return 0;
}
```