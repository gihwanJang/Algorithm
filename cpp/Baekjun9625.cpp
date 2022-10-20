#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, dp[46];
    scanf("%d", &n);

    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; ++i)
        dp[i] = dp[i - 1] + dp[i - 2];

    printf("%d %d\n", dp[n - 1], dp[n]);
    return 0;
}
