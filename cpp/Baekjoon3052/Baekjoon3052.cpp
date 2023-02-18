#include<stdio.h>
int main(int argc, char const *argv[]){
    int count=0;
    int mod[42]={0,};
    for(int i=0,tmp; i<10; ++i){
        scanf("%d",&tmp);
        ++mod[tmp%42];
    }
    for(int i=0; i<42; ++i)
        if(mod[i]>0)++count;
    printf("%d",count);
    return 0;
}
