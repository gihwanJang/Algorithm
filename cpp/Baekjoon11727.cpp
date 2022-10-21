#include<cstdio>
using namespace std;

int n, dp[1001];

int main(int argc, char const *argv[]){
    scanf("%d", &n);

    dp[1] = 1;
    dp[2] = 3;
    for(int i = 3; i <= n; ++i)
        dp[i] += (dp[i - 1] % 10007 + (2 * dp[i - 2]) % 10007) % 10007;

    printf("%d\n", dp[n]);
    return 0;
}
