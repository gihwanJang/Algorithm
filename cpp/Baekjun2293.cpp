#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, k, nums[101], dp[10001] = {1,};

    scanf("%d %d", &n, &k);
    for(int i = 1; i <= n; ++i)
        scanf("%d", &nums[i]);
    
    for(int i = 1; i <= n; ++i)
        for(int j = nums[i]; j <= k; ++j)
            dp[j] = dp[j] + dp[j - nums[i]];

    printf("%d\n", dp[k]);
    return 0;
}
