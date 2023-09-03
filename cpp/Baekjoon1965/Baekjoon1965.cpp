#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int getMaximumCount(vector<int>&boxs, int n)
{
    int cnt = 1;
    vector<int> dp(n, 1);

    for(int i = 1; i < n; ++i)
        for(int j = 0; j < i; ++j)
            if(boxs[i] > boxs[j])
                dp[i] = max(dp[j]+1, dp[i]);

    for(int i = 1; i < n; ++i)
        cnt = max(cnt, dp[i]);

    return cnt;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int>boxs(n);
    for(int i = 0; i < n; ++i)
        cin >> boxs[i];

    cout << getMaximumCount(boxs, n) << "\n";
    return 0;
}