#include<stdio.h>

bool check(int n){
    if(n>999)return false;
    int nums[3];
    for(int i=0; i<3; ++i,n/=10)
        nums[i]=n%10;
    if(nums[0]-nums[1]==nums[1]-nums[2])
        return true;
    return false;
}
int main(int argc, char const *argv[]){
    int n,count=0;
    scanf("%d",&n);
    for(;n>0;--n){
        if(n<100)++count;
        else if(check(n))++count;
    }
    printf("%d",count);
    return 0;
}
