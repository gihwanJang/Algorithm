#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, dp[1000001];
    
    scanf("%d", &n);
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; ++i)
        dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007) % 1000000007;
    
    printf("%d\n", dp[n]);
    return 0;
}
