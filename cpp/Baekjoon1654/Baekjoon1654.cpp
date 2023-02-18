#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int k, n, nums[10000], ans = 0;
    long mid, min = 1, max = 0;

    scanf("%d %d", &k, &n);
    for(int i = 0; i < k; ++i){
        scanf("%d", &nums[i]);
        if(max < nums[i]) max = nums[i];
    }

    while(min <= max){
        int count = 0;
        mid = (min + max) / 2;
        for(int i = 0; i < k; ++i)
            count += nums[i] / mid;
        if (count < n)
			max = mid - 1;
		else{
            min = mid + 1;
            if (ans < mid) ans = mid;
        }
    }

    printf("%d\n", ans);
    return 0;
}
