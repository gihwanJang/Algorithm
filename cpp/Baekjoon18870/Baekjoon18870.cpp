#include<iostream>
#include<vector>
#include<algorithm>
#include<set>

using namespace std;

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    int nums[n];

    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);
    
    vector<int> sortNums(nums, nums + n);
    sort(sortNums.begin(), sortNums.end());
    sortNums.erase(unique(sortNums.begin(), sortNums.end()), sortNums.end());

    for(int i = 0; i < n; ++i)
        printf("%ld ", lower_bound(sortNums.begin(), sortNums.end(), nums[i]) - sortNums.begin());
    
    printf("\n");
    return 0;
}
