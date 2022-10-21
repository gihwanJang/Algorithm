#include <cstdio>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    int nums[3];
    for(int i = 0; i < 3; ++i)
        scanf("%d", &nums[i]);
    
    sort(nums, nums + 3);

    for(int i = 0; i < 3; ++i)
        printf("%d ", nums[i]);
    return 0;
}
