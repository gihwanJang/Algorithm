#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int fourSquares(int n){
    vector<int> dp(n+1);

    dp[1] = 1;
    for (int i = 1; i <= n; ++i){
		dp[i] = dp[1] + dp[i - 1];

		for (int j = 2; j * j <= i; j++)
			dp[i] = min(dp[i], dp[i - j * j] + 1);
	}

    return dp[n];
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << fourSquares(n) << "\n";
    return 0;
}