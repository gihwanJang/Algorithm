#include <iostream>
#include <vector>

using namespace std;

long getRoute(vector<vector<int>>&board, int n)
{
    vector<vector<long>> dp(n, vector<long>(n));

    dp[0][0] = 1;
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
        {
            if(r + board[r][c] < n && (r != n-1 || c != n-1))
                dp[r + board[r][c]][c] += dp[r][c];
            if(c + board[r][c] < n && (r != n-1 || c != n-1))
                dp[r][c + board[r][c]] += dp[r][c];
        }

    return dp[n-1][n-1];
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> board(n, vector<int>(n));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            cin >> board[r][c];

    cout << getRoute(board, n) << "\n";
    return 0;
}
