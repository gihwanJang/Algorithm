#include<stdio.h>

int solution(int k, int n){
    int contain[n];

    for(size_t i = 0; i < n; ++i)
        contain[i]=i+1;

    for(; k > 0; --k)
        for(size_t i = 1; i < n; ++i)
            contain[i]=contain[i-1]+contain[i];
    
    return contain[n-1];
}

int main(int argc, char const *argv[]){
    int T,k,n;
    scanf("%d",&T);
    for(; T > 0; --T){
        scanf("%d %d", &k, &n);
        
        printf("%d\n",solution(k,n));
    }
    return 0;
}
