#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n;
    long dp[91];
    scanf("%d", &n);

    dp[0] = 0;
    dp[1] = dp[2] = 1;

    for(int i = 3; i <= n; ++i)
        dp[i] = dp[i - 1] + dp[i - 2];
    
    printf("%ld\n", dp[n]);
    return 0;
}
