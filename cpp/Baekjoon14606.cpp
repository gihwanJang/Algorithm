#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, dp[11];
    scanf("%d", &n);

    dp[1] = 0;
    for(int i = 2; i <= n; ++i)
        dp[i] = dp[i / 2] + dp[i - i / 2] + (i/2) * (i - i /2);
    
    printf("%d\n", dp[n]);
    return 0;
}
