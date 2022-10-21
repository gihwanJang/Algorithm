#include<stdio.h>
int main(int argc, char const *argv[]){
    int max[2]={-1,-1};
    for(int i=1,tmp; i<10; ++i){
        scanf("%d",&tmp);
        if(tmp>max[0]){
            max[0]=tmp;
            max[1]=i;
        }
    }
    printf("%d\n%d",max[0],max[1]);
    return 0;
}
