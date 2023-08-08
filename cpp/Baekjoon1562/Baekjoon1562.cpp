#include <iostream>
#include <vector>

#define MOD 1000000000

using namespace std;

int getStairNum(int n)
{
    int res = 0;
    int last_bit = (1 << 10) - 1; 
    int len, num, bit;
    vector<vector<vector<int>>> dp(n+1, vector<vector<int>>(10, vector<int>(1 << 10)));

    for(num = 1; num <= 9; ++num)
        dp[1][num][1 << num] = 1;

    for(len = 2; len <= n; ++len)
        for(num = 0; num <= 9; ++num)
            for(bit = 0; bit <= last_bit; ++bit)
            {
                if(num == 0)
                    dp[len][0][bit | (1 << 0)] = (dp[len][0][bit | (1 << 0)] + dp[len - 1][1][bit]) % MOD;
                else if(num == 9)
                    dp[len][9][bit | (1 << 9)] = (dp[len][9][bit | (1 << 9)] + dp[len - 1][8][bit]) % MOD;
                else
                {
                    dp[len][num][bit | (1 << num)] = (dp[len][num][bit | (1 << num)] + dp[len - 1][num - 1][bit]) % MOD;
                    dp[len][num][bit | (1 << num)] = (dp[len][num][bit | (1 << num)] + dp[len - 1][num + 1][bit]) % MOD;
                }
            }

    for (num = 0; num <= 9; ++num)
        res = (res + dp[n][num][last_bit]) % MOD;

    return res;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << getStairNum(n) << "\n";
    return 0;
}
