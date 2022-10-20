#include <cstdio>
#include <vector>
using namespace std;

int main(int argc, char const *argv[]){
    int r, c, w, ans = 0;
    vector<int> dp[30];

    scanf("%d %d %d", &r, &c, &w);

    dp[0].push_back(1);
    for(int i = 1; i < r + w; ++i){
        dp[i].push_back(1);
        for(int j = 1; j < i; ++j)
            dp[i].push_back(dp[i - 1][j - 1] + dp[i - 1][j]);
        dp[i].push_back(1);
    }

    for(int i = 0; i < w; ++i)
        for(int j = 0; j <= i; ++j)
            ans += dp[r + i - 1][c + j - 1];

    printf("%d\n", ans);
    return 0;
}
