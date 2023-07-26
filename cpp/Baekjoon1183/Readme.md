# (1183) 약속
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1183)
#
## 문제
마법사 N명이 머글 문화를 이해하기 위해 머글과 약속을 잡았다. 각 마법사는 한 명의 머글을 만날 예정이다. 하지만, 마법사는 약속 시간보다 빨리 또는 늦게 도착할 수 있기 때문에 고민에 빠졌다. 결국 기다리는 시간을 최소화 하기 위해 모든 약속 시간을 T씩 미루려고 한다. 기다리는 시간은 먼저 도착한 사람이 늦게 도착한 사람이 도착할 때까지 기다리는 시간을 의미한다.

마법사의 약속 시간은 A1, A2, ..., AN이고, 도착 시간은 B1, B2, ..., BN이다. 약속 시간을 T만큼 미루면, 기다리는 시간의 합은 |Ai + T - Bi|의 합과 같다. 기다리는 시간의 합이 최소가 되는 서로 다른 정수 T의 개수를 구해보자.
#
## 입력
첫째 줄에 N이 주어진다. 다음 N개의 줄에 Ai, Bi가 주어진다.
#
## 출력
첫째 줄에 기다리는 시간의 합이 최소인 서로 다른 정수 T의 개수를 출력한다.
#
## 풀이
해당 문제는 정렬을 이용하면 해결 할 수 있는 문제입니다.

우선 위의 문제를 식으로 정리할 필요가 있습니다.  
y를 시간의 합 x를 Ai-Bi로 치환을 한다면 y = |x1 + T| + |x2 + T| + ... + |xn + T|로 식을 정리 할 수 있습니다.  
이때 y를 최솟 값으로 만들기 위헤서는 x를 기준으로 정렬을 한 뒤 중앙의 구간을 선택하면 됩니다.  

그러므로 n의 갯수가 홀수이면 중앙 값은 1개이므로 1을 출력하고 짝수이면 중앙의 구간에 값이 여러개가 나오므로 중앙의 구간의 가장 큰 값에서 가장 작은 값을 뺀 값을 출력해 줍니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int getOptimalNumberOfValues(vector<int>&times, int n)
{
    if(n % 2 == 1) return 1;

    sort(times.begin(), times.end());
    return times[n / 2] - times[n / 2 - 1] + 1;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, a, b;
    cin >> n;

    vector<int> times(n);
    for(int i = 0; i < n; ++i)
    {
        cin >> a >> b;
        times[i] = a - b;
    }

    cout << getOptimalNumberOfValues(times, n) << "\n";    
    return 0;
}
```