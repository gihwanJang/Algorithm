# (1246) 온라인 판매
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1246)
#
## 문제
경래는 닭을 기르는데 올 겨울 달걀 풍년으로 함박 웃음을 짓고 있다. 그리고 이 달걀을 영양란으로 둔갑하여 옥션에 판매하려한다.

경래는 총 N개의 달걀이 있고, 그의 잠재적인 고객은 총 M명이다. 그리고 각각의 i번째 고객은 각자 달걀 하나를 Pi 가격 이하로 살 수 있다고 밝혔다.

경래는 영양란이라 속인 죄책감에 한 고객에게 두 개 이상의 달걀은 팔지 않기로 하였다. 하지만 위의 규칙 하에 수익은 최대로 올리고 싶기에 얼마로 팔지 고민하고 있다. 즉, A가격에 달걀을 판다고 하면 Pi가 A가격보다 크거나 같은 모든 고객은 달걀을 산다는 뜻이다. (물론 달걀 총 수량을 초과하여 팔 수 는 없다)

문제는 이러한 경래를 도와 최대 수익을 올릴 수 있는 달걀의 가장 낮은 가격을 책정하는 것이다.
#
## 입력
첫째 줄에 정수 N(1 ≤ N ≤ 1,000)과 M(1 ≤ M ≤ 1,000)이 입력된다. 둘째 줄부터 M+1번째 줄까지 i+1번째 줄에는 Pi(1 ≤ Pi ≤ 1,000,000)가 입력된다.
#
## 출력
첫째 줄에 경래가 책정한 가격과 이 가격으로 올릴 수 있는 수익을 출력한다.
#
## 풀이
해당 문제는 정렬로 풀 수 있는 문제입니다.  

우선 가격 상한선을 오름차순으로 정렬합니다.  
이후 처음부터 끝까지 받을 수 있는 값을 구하는 데 식은 아래와 같습니다.  

- limt[i] * (n > m-i ? m-i : n)

위의 식을 통해 가장 큰 값을 출력해 주면 됩니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void pricing(int n, int m, vector<int>&limt, int&ans1, int&ans2){
    sort(limt.begin(), limt.end());

    ans1 = limt[0];
    ans2 = limt[0] * (n > m ? m : n);
    
    for(int i = 1; i < m; ++i)
        if(ans2 < limt[i] * (n > m-i ? m-i : n)){
            ans1 = limt[i];
            ans2 = limt[i] * (n > m-i ? m-i : n);
        }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans1 = 0, ans2 = 0;
    cin >> n >> m;

    vector<int> limt(m);
    for(int i = 0; i < m; ++i)
        cin >> limt[i];

    pricing(n,m,limt,ans1,ans2);
    cout << ans1 << " " << ans2 << "\n";
    return 0;
}
```