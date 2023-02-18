#include<stdio.h>
int solution(int a,int b,int c){
    int cost=0,max;
    if(a==b&&b==c)cost+=a*1000+10000;
    else if(a==b) cost+=a*100+1000;
    else if(b==c) cost+=b*100+1000;
    else if(a==c) cost+=a*100+1000;
    else{
        max=a>b?a:b;
        max=max>c?max:c;
        cost+=max*100;
    }
    return cost;
}
int main(int argc, char const *argv[]){
    int a,b,c;
    scanf("%d %d %d",&a,&b,&c);
    printf("%d",solution(a,b,c));
    return 0;
}
