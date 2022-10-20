#include <cstdio>
#include <algorithm>
using namespace std;

int T, n, ans, nums[1001];

int main(int argc, char const *argv[]){
    scanf("%d", &T);
    while (T--){
        scanf("%d", &n);
        for(int i = 0; i < n; ++i)
            scanf("%d", &nums[i]);
        
        ans = nums[0];
        for(int i = 1; i < n; ++i){
            nums[i] = max(nums[i], nums[i - 1] + nums[i]);
            ans = max(ans, nums[i]);
        }

        printf("%d\n", ans);
    }
    
    return 0;
}
