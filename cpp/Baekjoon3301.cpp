#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n;
    long dp[81];
    scanf("%d", &n);
    
    dp[0] = 0;
    dp[1] = dp[2] = 1;
    dp[3] = 2;

    for(int i = 4; i <= n; ++i)
        dp[i] = dp[i-1] + dp[i-3] + dp[i-4];

    printf("%ld\n", dp[n]*4 + dp[n-1]*2);
    return 0;
}
