#include <cstdio>
using namespace std;

long n, dp[91];

int main(int argc, char const *argv[]){
    scanf("%ld", &n);
    
    dp[1] = dp[2] = 1;
    for(int i = 3; i <= n; ++i)
        dp[i] = dp[i - 1] + dp[i - 2];
    
    printf("%ld\n", dp[n]);
    return 0;
}
