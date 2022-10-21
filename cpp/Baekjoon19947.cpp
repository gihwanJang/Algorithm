#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    int Y, dp[16] = {0,}, ans = 0;

    scanf("%d %d", &dp[0], &Y);

    for(int i = 0; i <= Y; ++i){
        if(dp[i + 1] < dp[i] * 1.05)dp[i + 1] = dp[i] * 1.05;
        if(dp[i + 3] < dp[i] * 1.2)dp[i + 3] = dp[i] * 1.2;
        if(dp[i + 5] < dp[i] * 1.35)dp[i + 5] = dp[i] * 1.35;
        ans = max(ans, dp[i]);
    }

    printf("%d\n", ans);
    return 0;
}
