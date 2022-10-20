#include<stdio.h>
#include <cmath>
int main(int argc, char const *argv[]){
    int T;
    scanf("%d",&T);
    for(;T>0;--T){
        int n,count=0;
        double avg=0,rate=0;
        scanf("%d",&n);
        int scores[n];
        for(int i=0; i<n; ++i){
            scanf("%d",&scores[i]);
            avg+=scores[i];
        }
        avg/=n;
        for(int i=0; i<n; ++i)
            if(scores[i]>avg)++rate;
        rate=rate/n*100;
        printf("%.3lf%%\n",round(rate*1000)/1000);
    }
    return 0;
}
