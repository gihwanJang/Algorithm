#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int findMaximum(vector<vector<int>>&stickers, int n){
    if(n == 1)
        return max(stickers[0][0], stickers[1][0]);

    vector<vector<int>> dp(2, vector<int>(n));
    dp[0][0] = stickers[0][0];
    dp[1][0] = stickers[1][0];
    dp[0][1] = stickers[1][0] + stickers[0][1];
    dp[1][1] = stickers[0][0] + stickers[1][1];

    for(int i = 2; i < n; ++i){
        dp[0][i] = max(dp[1][i - 1] + stickers[0][i],dp[1][i - 2] + stickers[0][i]);
        dp[1][i] = max(dp[0][i - 1] + stickers[1][i],dp[0][i - 2] + stickers[1][i]);
    }

    return max(dp[0][n - 1], dp[1][n - 1]);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T, n;
    cin >> T;

    while(T--){
        cin >> n;

        vector<vector<int>> stickers(2, vector<int>(n));
        for(int r = 0; r < 2; ++r)
            for(int c = 0; c < n; ++c)
                cin >> stickers[r][c];
        
        cout << findMaximum(stickers, n) << "\n";
    }
    return 0;
}
