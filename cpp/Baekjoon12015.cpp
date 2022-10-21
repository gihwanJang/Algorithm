#include <cstdio>
using namespace std;

int n, nums[100000], d[100000], end = 0;

void search(int k){
    int low  = 0, high = end, mid = (low + high) / 2;
    while(high >= low){
        if(d[mid] <= k) low = mid + 1;
        else high = mid - 1;
        mid = (low + high) / 2;
    }
    d[mid] = k;
}

int main(int argc, char const *argv[]){
    scanf("%d", &n);
    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);
    
    d[0] = 0;
    for(int i = 0; i < n; ++i){
        if(nums[i] > d[end]) d[++end] = nums[i];
        else search(nums[i]);
    }

    printf("%d\n", end);
    return 0;
}
