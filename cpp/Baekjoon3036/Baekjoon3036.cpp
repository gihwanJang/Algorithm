#include<iostream>

int GCD(int a, int b){
    if(b == 0) return a;
    else return GCD(b, a%b);
}

int main(int argc, char const *argv[]){
    int n, f, gcd;
    scanf("%d %d", &n, &f);
    int nums[n-1];
    for(int i = 0; i < n-1; ++i)
        scanf("%d", &nums[i]);
    
    for(int i = 0; i < n-1; ++i){
        gcd = GCD(f,nums[i]);
        printf("%d/%d\n", f/gcd, nums[i]/gcd);
    }
    return 0;
}
