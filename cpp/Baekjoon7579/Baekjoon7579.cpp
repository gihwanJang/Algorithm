#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct Item{ int weight, value; };

int getProfitSchedule(vector<Item>&items, int n, int m, int sum)
{
    int profit = 0;
    vector<vector<int>> dp(n+1, vector<int>(sum+1));

    for(int i = 1; i <= n; ++i)
        for(int j = 0; j <= sum; ++j)
        {
            if(j - items[i].weight >= 0)
                dp[i][j] = max(dp[i-1][j], dp[i - 1][j - items[i].weight] + items[i].value);
            else
                dp[i][j] = dp[i-1][j];
        }

    for(int i = 0; i <= sum; ++i)
        if(dp[n][i] >= m)
            return i;

    return 0;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, sum = 0;
    cin >> n >> m;

    vector<Item> items(n+1);
    for(int i = 1; i <= n; ++i)
        cin >> items[i].value;
    for(int i = 1; i <= n; ++i)
    {
        cin >> items[i].weight;
        sum += items[i].weight;
    }

    cout << getProfitSchedule(items, n, m, sum) << "\n";
    return 0;
}
