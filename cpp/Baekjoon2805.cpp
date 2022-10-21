#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, nums[1000000];
    long mid, low = 1, high = 0, ans = 0;

    scanf("%d %d", &n, &m);
    for(int i = 0; i < n; ++i){
        scanf("%d", &nums[i]);
        if(nums[i] > high)
            high = nums[i];
    }
    
    for(long count = 0; low <= high; count = 0){
        mid = (low + high) / 2;
        for(int i = 0; i < n; ++i)
            if(nums[i] - mid > 0)
                count += nums[i] - mid;
        if(count < m)
            high = mid - 1;
        else{
            low = mid + 1;
            if(ans < mid) ans = mid;
        }
    }

    printf("%ld\n", ans);
    return 0;
}
