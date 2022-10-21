#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n;
    bool dp[1001];

    scanf("%d", &n);

    dp[1] = dp[3] =  true;
    dp[2] = false;
    for(int i = 4; i <= n; ++i)
        dp[i] = (!dp[i - 1] || !dp[i - 3]);
    
    printf("%s\n", dp[n] ? "SK" : "CY");
    return 0;
}
