#include<iostream>

int main(int argc, char const *argv[]){
    int n, nums[10001] = {0,};
    scanf("%d", &n);
    for(int i = 0; n > 0; --n){
        scanf("%d", &i);
        ++nums[i];
    }

    for(int i = 1; i < 10001; ++i)
        if(nums[i] != 0)
            for(; nums[i] > 0; --nums[i])
                printf("%d\n", i);

    return 0;
}
