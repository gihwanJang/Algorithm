#include<stdio.h>
int main(int argc, char const *argv[]){
    int n,x;
    scanf("%d %d",&n,&x);
    int nums[n];
    for(int i=0;i<n;++i)
        scanf("%d",&nums[i]);
    for(int i=0;i<n;++i)
        if(nums[i]<x)
            printf("%d ",nums[i]);
    return 0;
}
