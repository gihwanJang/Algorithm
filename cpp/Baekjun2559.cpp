#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, k, nums[100001], ans = -1000000000;

    scanf("%d %d", &n, &k);
    for(int i = 1; i <= n; ++i){
        scanf("%d", &nums[i]);
        nums[i] += nums[i - 1];
    }
    
    for(int i = k; i <= n; ++i)
        if(ans < nums[i] - nums[i-k])
            ans = nums[i] - nums[i-k];

    printf("%d\n", ans);
    return 0;
}
