#include <cstdio>
#include <algorithm>
using namespace std;

int n;
bool dp[1001];

int main(int argc, char const *argv[]){
    scanf("%d", &n);

    dp[1] = dp[3] = true;
    dp[2] = dp[4] = false;
    for(int i = 4; i <= n; ++i)
        dp[i] = (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]);
    
    printf("%s\n", dp[n] ? "SK" : "CY");
    return 0;
}
