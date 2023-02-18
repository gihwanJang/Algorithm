#include<stdio.h>
int main(int argc, char const *argv[]){
    int n,max=-1000000,min=1000000;
    scanf("%d",&n);
    for(int i=0,tmp; i<n; ++i){
        scanf("%d",&tmp);
        if(tmp>max)max=tmp;
        if(tmp<min)min=tmp;
    }
    printf("%d %d",min,max);
    return 0;
}
