# (1072) 게임
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1072)
#
## 문제
김형택은 지금 몰래 Spider Solitaire(스파이더 카드놀이)를 하고 있다. 형택이는 이 게임을 이길 때도 있었지만, 질 때도 있었다. 누군가의 시선이 느껴진 형택이는 게임을 중단하고 코딩을 하기 시작했다. 의심을 피했다고 생각한 형택이는 다시 게임을 켰다. 그 때 형택이는 잠시 코딩을 하는 사이에 자신의 게임 실력이 눈에 띄게 향상된 것을 알았다.

이제 형택이는 앞으로의 모든 게임에서 지지 않는다. 하지만, 형택이는 게임 기록을 삭제 할 수 없기 때문에, 자신의 못하던 예전 기록이 현재 자신의 엄청난 실력을 증명하지 못한다고 생각했다.

게임 기록은 다음과 같이 생겼다.

- 게임 횟수 : X
- 이긴 게임 : Y (Z%)
- Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.

X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오.
#
## 입력
각 줄에 정수 X와 Y가 주어진다.
#
## 출력
첫째 줄에 형택이가 게임을 최소 몇 판 더 해야하는지 출력한다. 만약 Z가 절대 변하지 않는다면 -1을 출력한다.
#
## 풀이
해당 문제는 이분탐색으로 해결 할 수 있는 문제입니다.

우선 처음의 승률을 구합니다.
이때 해당 승률은 1번이라도 질 경우 100%가 될 수 없음으로 99%이상일 경우 -1을 출력합니다.

이후 입력의 최댓 값이 10억 이므로 최대 10억에서 이분탐색을 통해 중앙 값을 각 x, y에 더해 구한 승률이 원래 승률 보다 크다면 최대는 mid-1 아니면 최저가 mid+1이 되도록 반복해줍니다.

이후 최저값을 출력해 줍니다.

```cpp
#include <iostream>

using namespace std;

int getOdds(long x, long y, long z)
{
    if(z >= 99) return -1;

    int left = 0;
    int right = 1000000000;
    int mid;

    while(left <= right)
    {
        mid = (left + right) / 2;

        if(z < (100 * (y + mid) / (x + mid)))
            right = mid - 1;
        else
            left = mid + 1;
    }

    return left;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long x, y, z;
    cin >> x >> y;
    z = 100 * y / x;

    cout << getOdds(x, y, z) << "\n";
    return 0;
}
```