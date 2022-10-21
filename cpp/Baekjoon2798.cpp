#include<iostream>

int solution(int n, int m, int nums[]){
    int close=-1;
    for(int i = 0; i < n - 2; ++i)
        for(int j = i + 1; j < n - 1; ++j)
            for(int k = j + 1; k < n; ++k){
                int v = nums[i] + nums[j] + nums[k];
                if(close < v && v <= m)
                    close = v;
            }

    return close;
}

int main(){
    int n, m;
    scanf("%d %d", &n, &m);
    int nums[m];
    for(int i = 0; i < n; ++i)
        scanf("%d", &nums[i]);

    printf("%d\n", solution(n, m, nums));
    return 0;
}