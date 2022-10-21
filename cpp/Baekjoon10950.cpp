#include<stdio.h>
int main(int argc, char const *argv[]){
    int T;
    scanf("%d",&T);
    for(;T>0;--T){
        int a,b;
        scanf("%d %d",&a,&b);
        printf("%d\n",a+b);
    }
    return 0;
}
