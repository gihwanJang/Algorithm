#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int T, p, q;
    long dp[10001];
    scanf("%d", &T);

    for(int i = 1; i <= T; ++i){
        scanf("%d %d", &p, &q);

        dp[1] = dp[2] = 1;
        for(int j = 3; j <= p; ++j)
            dp[j] = (dp[j - 1] + dp[j - 2]) % q;

        printf("Case #%d: %ld\n", i, dp[p] % q);
    }
    return 0;
}