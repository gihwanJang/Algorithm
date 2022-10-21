#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, dp[10000001];
    scanf("%d", &n);
    
    dp[0] = dp[1] = 1;
    for(int i = 2; i <= n; ++i)
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10;
    
    printf("%d\n", dp[n] % 10);
    return 0;
}
