#include<iostream>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    int nums[n];
    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);

    sort(nums, nums+n);

    for(int i = 0; i < n; ++i)
        printf("%d\n", nums[i]);

    return 0;
}
