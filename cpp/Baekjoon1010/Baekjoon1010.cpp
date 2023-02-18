#include<iostream>

long factorial(int start, int end){
    long k = 1;

    for(int i = start+1; i <= end; ++i)
        k *= i;

    return k;
}

int comb(int n, int r){
    int big = n-r, small = r;
    if(r > n-r){
        big = r;
        small = n-r;
    }
    return int(factorial(big, n) / factorial(0, small));
}

int main(int argc, char const *argv[]){
    int T, n, m;
    for(scanf("%d",&T); T > 0; --T){
        scanf("%d %d", &n, &m);
        
        printf("%d\n", comb(m, n));
    }

    return 0;
}
