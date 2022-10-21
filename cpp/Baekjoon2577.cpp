#include<stdio.h>
int main(int argc, char const *argv[]){
    int multi=1;
    int count[10]={0,};
    for(int i=0,tmp;i<3;++i){
        scanf("%d",&tmp);
        multi*=tmp;
    }
    while(multi!=0){
        ++count[multi%10];
        multi/=10;
    }
    for(int i=0; i<10; ++i)
        printf("%d\n",count[i]);
    return 0;
}
