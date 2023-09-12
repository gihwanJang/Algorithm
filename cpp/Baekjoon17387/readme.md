# (17387) 선분 교차 2
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/17387)
#
## 문제
2차원 좌표 평면 위의 두 선분 L1, L2가 주어졌을 때, 두 선분이 교차하는지 아닌지 구해보자. 한 선분의 끝 점이 다른 선분이나 끝 점 위에 있는 것도 교차하는 것이다.

L1의 양 끝 점은 (x1, y1), (x2, y2), L2의 양 끝 점은 (x3, y3), (x4, y4)이다.
#
## 입력
첫째 줄에 L1의 양 끝 점 x1, y1, x2, y2가, 둘째 줄에 L2의 양 끝 점 x3, y3, x4, y4가 주어진다.
#
## 출력
L1과 L2가 교차하면 1, 아니면 0을 출력한다.
#
## 풀이
해당 문제는 CCW를 이용하면 해결 할 수 있는 문제입니다.  

우선 CCW에 대하여 간단히 설명하면 한 선분을 포함하는 직선에 대하여 점의 위치가 반시계 방향이면 1 시계 방향이면 -1 해당 직선 위에 놓여있으면 0을 반환하는 알고리즘입니다.  

해당 알고리즘을 응용하면 두 선분의 위치 관계를 파악 할 수 있습니다.  

한 선분에 대하여 두점의 CCW의 값을 계산하여 곱을 취할 경우(CCW(Line ab, Point c) * CCW(Line ab, Point d)) 3가지 경우가 나옵니다.  
이후 선분으로 선택하지 않은 두 점을 선분으로하고 선분으로 나머지 두점의 CCW의 값을 계산하여 곱을 취할 경우(CCW(Line cd, Point a) * CCW(Line cd, Point b)) 3가지 가 나옵니다.  

- CCW(Line ab, Point c) * CCW(Line ab, Point d) = direct1
- CCW(Line cd, Point a) * CCW(Line cd, Point b) = direct2

1. (direct1 = 1, direct2 = 1) : 두 선분은 완전히 동떨어진 모양을 나타 내게 됩니다.(만나지 않음)
2. (direct1 = 1, direct2 = -1) : 한 선분에 대하여 위나 아래 쪽에서 직선을 가로지르는 선분이 생성 됩니다.(만나지 않음)
3. (direct1 = -1, direct2 = 1) : 위와 동일 (만나지 않음)
4. (direct1 = 0, direct2 = 1) : 한 선분에 대하여 위나 아래 쪽에서 직선에서 시작하는 선분이 생성 됩니다.(만나지 않음)
5. (direct1 = 1, direct2 = 0) : 위와 동일 (만나지 않음)
6. (direct1 = 0, direct2 = -1) : 한 선분에 대하여 선분위에서 시작하는 선분이 생성 됩니다.(만남)
7. (direct1 = -1, direct2 = 0) : 위와 동일 (만남)
8. (direct1 = -1, direct2 = -1) : 교차하는 선분이 생성 됩니다.(만남)
9. (direct1 = 0, direct2 = 0) : 두선분이 한 직선 위에 생성 됩니다. (여러 경우로 나뉨)

9번의 경우 선분이 만나는지 확인 하기 위해 해당 점들의 범위를 확인하면 만나는지 만나지 않는지 구분이 가능합니다.  

위의 내용을 바탕으로 구현을 하게 되면 우선 점과 선을 구분하기위하여 점, 선에 대한 구조체 또는 클래스를 만듭니다.  
두 선분에 대한 점들의 값을 입력받습니다.  
해당 선분에 대하여 CCW를 각각 계산합니다.  
이때 각각 계산한 값들 중 하나라도 양수 이면 false를 반환합니다.  
모두 0이하일 경우 둘다 0이 아니라면 true를 반환합니다.
둘다 0이라면 선분을 x값에 대하여 만약 같다면 y값에 대하여 오름 차순으로 정렬후 각 선분들의 가장 먼 점들을 비교 한것과 각 선분의  가장 가까운 점들을 비교 한 것이 같다면 true 아니면 false를 반환합니다.  

반환 값이 true면 1 false면 0을 출력합니다.

```cpp
#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;

struct Point{long x, y;};
struct Line{Point p1, p2;};

int CCW(Line&l, Point p)
{
    long direct = (l.p1.x * l.p2.y + l.p2.x * p.y + p.x * l.p1.y) - (l.p2.x * l.p1.y + p.x * l.p2.y + l.p1.x * p.y);

    if(direct > 0) return 1;
    else if(direct < 0) return -1;
    else return 0;
}

bool cmpPoint(Point a, Point b)
{
    if(a.x == b.x)
        return a.y <= b.y;
    return a.x <= b.x;
}

bool canCrossLine(Line&l1, Line&l2)
{
    int loc_state1 = CCW(l1, l2.p1) * CCW(l1, l2.p2);
    int loc_state2 = CCW(l2, l1.p1) * CCW(l2, l1.p2);

    if(loc_state1 <= 0 && loc_state2 <=0 )
    {
        if(loc_state1 == 0 && loc_state2 == 0)
        {
            if(cmpPoint(l1.p2, l1.p1)) swap(l1.p1, l1.p2);
            if(cmpPoint(l2.p2, l2.p1)) swap(l2.p1, l2.p2);
            
            return cmpPoint(l1.p1, l2.p2) && cmpPoint(l2.p1, l1.p2);
        }
        return true;
    }

    return false;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Line l1, l2;
    cin >> l1.p1.x >> l1.p1.y >> l1.p2.x >> l1.p2.y;
    cin >> l2.p1.x >> l2.p1.y >> l2.p2.x >> l2.p2.y;

    cout << canCrossLine(l1, l2) << "\n";
    return 0;
}
```