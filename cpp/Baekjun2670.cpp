#include <cstdio>
#include <algorithm>
#include <cmath>
using namespace std;

int n;
double ans = 0, nums[10001], dp[10001];

int main(int argc, char const *argv[]){
    scanf("%d", &n);
    for(int i = 0; i < n; ++i)
        scanf("%lf", &nums[i]);
    
    dp[0] = nums[0];
    for(int i = 1; i < n; ++i){
        dp[i] = max(nums[i], dp[i - 1] * nums[i]);
        ans = max(ans, dp[i]);
    }
    
    printf("%.3lf\n", round(ans * 1000) / 1000);
    return 0;
}
