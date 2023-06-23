# (1002) 터렛
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1002)
#
## 문제
조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.

![img1](https://www.acmicpc.net/upload/201003/dfcmhrjj_142c3w76qg8_b.jpg)

이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 음이 아닌 정수이다.
## 출력
각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
#
## 풀이
해당 문제는 두 원과 반지름 관계를 이용하면 풀 수 있는 문제입니다.

두원과 반지름의 관계는 아래와 같습니다.

|두 점|한 점(내접)|한 점(외접)|일치|만나지않는다(외부)|만나지않는다(내부)|
|---|---|---|---|---|---|
|차 < 거리 < 합|차 == 거리|합 == 거리|거리 == 0, 차 == 0|거리 < 차|거리 > 합|

이때 한 가지 고려해야할 점은 반지름이 0인 경우인데 이때는 사정거리안에 적이 없으므로 0을 출력해 주어야합니다.   

또한 거리의 경우 유클리드 거리를 사용하게 되는데 double로 비교를 할 경우 부동소수의 오차가 발생 할 수 있어 두변을 모두 제곱하여 계산 하는 방식으로 비교를 할때 정수 끼리 하는 것이 좋습니다.

```cpp
#include <iostream>

using namespace std;

struct Turret
{
    int x, y, r;
};

int getEnemyPosition(Turret&t1, Turret&t2)
{
    int d = (t2.x - t1.x) * (t2.x - t1.x) + (t2.y - t1.y) * (t2.y - t1.y);
    int sum = (t1.r + t2.r) * (t1.r + t2.r);
    int sub = (t1.r - t2.r) * (t1.r - t2.r);

    if(d == 0 && t1.r != 0 && t2.r != 0 && t1.r == t2.r)
        return -1;
    else if(sub < d && d < sum)
        return 2;
    else if(d == sum || d == sub)
        return 1;
    else
        return 0;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while(T--)
    {
        Turret t1, t2;

        cin >> t1.x >> t1.y >> t1.r;
        cin >> t2.x >> t2.y >> t2.r;

        cout << getEnemyPosition(t1, t2) << "\n";
    }
    return 0;
}
```