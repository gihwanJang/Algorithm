#include <iostream>
#include <vector>

using namespace std;

int getCount(int n)
{
    if(n%2) return 0;

    vector<int> dp(n+1);
    dp[0] = 1;
    dp[2] = 3;

    for(int i = 4; i <= n; ++i)
    {
        dp[i] = dp[i-2] * dp[2];

        for(int j = i-4; j >= 0; j -= 2)
            dp[i] += dp[j] * 2;
    }

    return dp[n];
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    cout << getCount(n) << "\n";
    return 0;
}
