#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n;
    long dp[117];

    scanf("%d", &n);

    dp[1] = dp[2] = dp[3] = 1;
    for(int i = 4; i <= n; ++i)
        dp[i] = dp[i - 1] + dp[i - 3];
    
    printf("%ld\n", dp[n]);
    return 0;
}
