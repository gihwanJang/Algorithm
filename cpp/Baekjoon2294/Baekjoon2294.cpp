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
