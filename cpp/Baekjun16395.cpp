#include <cstdio>
#include <vector>
using namespace std;

int main(int argc, char const *argv[]){
    int n, k;
    vector<int> dp[31];

    scanf("%d %d", &n, &k);
    dp[1].push_back(1);
    for(int i = 2; i <= n; ++i){
        dp[i].push_back(1);
        for(int j = 1; j < i - 1; ++j)
            dp[i].push_back(dp[i - 1][j - 1] + dp[i - 1][j]);
        dp[i].push_back(1);
    }

    printf("%d\n", dp[n][k - 1]);
    return 0;
}
