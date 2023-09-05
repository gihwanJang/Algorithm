# (2294) 동전 2
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2294)
#
## 문제
n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그러면서 동전의 개수가 최소가 되도록 하려고 한다. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
#
## 입력
첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다. 가치가 같은 동전이 여러 번 주어질 수도 있다.
#
## 출력
첫째 줄에 사용한 동전의 최소 개수를 출력한다. 불가능한 경우에는 -1을 출력한다.
#
## 풀이
해당 문제는 다이나믹 프로그래밍을 활용하면 해결 할 수 있는 문제입니다.  

우선 동전의 종류 수(n), 원하는 금액(k), 각 동전의 종류(coins)를 입력 받습니다.  

이후 각 동전의 갯수를 저장할 수 있는 dp배열을 k사이즈로 선언해 줍니다.  
각 인덱스는 해당 금액을 뜻하며 해당 금액에 대하여 각 동전을 더했을 때 k원 이하라면 더한 겂의 인덱스를 최솟값으로 갱신 해줍니다.  
즉 점화식은 아래와 같습니다.  
if(i + coins[j] <= k) -> dp[i + coins[j]] = min(dp[i + coins[j]], dp[i] + 1);

이후 k인덱스의 값을 출력해 주시면 됩니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

#define INF 2000000000

using namespace std;

int getMinimumCoins(vector<int>&coins, int n, int k)
{
    vector<int> dp(k+1, INF);

    dp[0] = 0;
    for(int i = 0; i < k; ++i)
        for(int j = 0; j < n; ++j)
            if(i + coins[j] <= k)
                dp[i + coins[j]] = min(dp[i + coins[j]], dp[i] + 1);

    return dp[k] == INF ? -1 : dp[k];
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for(int i = 0; i < n; ++i)
        cin >> coins[i];

    cout << getMinimumCoins(coins, n, k) << "\n";
    return 0;
}
```