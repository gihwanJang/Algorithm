#include<stdio.h>
int main(int argc, char const *argv[]){
    int n,sum=0;
    scanf("%d",&n);
    for(;n>0;--n)
        sum+=n;
    printf("%d",sum);
    return 0;
}
