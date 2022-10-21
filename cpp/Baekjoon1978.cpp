#include<stdio.h>
#include<math.h>

int solution(int n,int nums[]){
    int count = 0;

    for(size_t i = 0; i < n; ++i){
        if(nums[i] == 1) continue;
        bool flag = true;

        for(size_t j = 2; j <= sqrt(nums[i]); ++j){
            if(nums[i] % j == 0){
                flag = false;
                break;
            }
        }
        
        if(flag) ++count;
    }

    return count;
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    int nums[n];
    for(size_t i = 0; i < n; ++i)
        scanf("%d", &nums[i]);
    
    printf("%d\n", solution(n, nums));
    return 0;
}
