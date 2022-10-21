#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(int a, int b){
    return a > b;
}

int main(int argc, char const *argv[]){
    int n , k;
    vector<int> nums;

    scanf("%d %d", &n, &k);
    for(int i = 0, num; i < n ; ++i){
        scanf("%d", &num);
        nums.push_back(num);
    }

    sort(nums.begin(), nums.end(), cmp);

    printf("%d\n", nums[k-1]);
    return 0;
}
