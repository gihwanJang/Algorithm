#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, start, end, nums[100001];

    nums[0] = 0;
    scanf("%d%d", &n, &m);
    for(int i = 1; i <= n; ++i){
        scanf("%d", &nums[i]);
        nums[i] += nums[i-1];
    }

    for(; m > 0; --m){
        scanf("%d%d", &start, &end);
        printf("%d\n", nums[end] - nums[start - 1]);
    }
    return 0;
}
