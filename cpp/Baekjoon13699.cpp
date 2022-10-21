#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n;
    long long dp[36] = {1, 1};
    scanf("%d", &n);

    for(int i = 2; i <= n; ++i)
        for(int j = 0; j < i; ++j)
            dp[i] += dp[j] * dp[i - j - 1];
    
    printf("%lld\n", dp[n]);
    return 0;
}
