#include <algorithm>
#include <iostream>
#include <climits>
#include <vector>

using namespace std;

struct Mat{int r, c;};

int getMinimumAmountOfComputation(vector<Mat>&mats, int n)
{
    vector<vector<int>> dp(n+2, vector<int>(n+2));

    for(int i = 1; i < n; ++i)
        for(int j = 1; i + j <= n; ++j)
        {   
            dp[j][i + j] = INT_MAX;

            for(int k = j; k <= i + j; ++k)
                dp[j][i + j] = min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + mats[j].r * mats[k].c * mats[i+j].c);
        }

    return dp[1][n];
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<Mat> mats(n+1);
    for(int i = 1; i <= n; ++i)
        cin >> mats[i].r >> mats[i].c;

    cout << getMinimumAmountOfComputation(mats, n) << "\n";
    return 0;
}
