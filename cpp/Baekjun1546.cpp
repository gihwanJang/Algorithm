#include<stdio.h>
int main(int argc, char const *argv[]){
    int n;
    scanf("%d",&n);
    double avg=0,max=0;
    double nums[n];
    for(int i=0,tmp; i<n; ++i){
        scanf("%lf",&nums[i]);
        if(nums[i]>max)max=nums[i];
    }
    for(int i=0; i<n; ++i)
        avg+=nums[i]/max*100;
    printf("%lf",avg/n);
    return 0;
}
