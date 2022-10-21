#include<stdio.h>
void solution(int&A,int&B,int C){
    int tmp;
    B+=C;
    if(B>59){
        tmp=B/60;
        B%=60;
        A+=tmp;
        if(A>23)A-=24;
    }
}
int main(int argc, char const *argv[]){
    int A,B,C;
    scanf("%d %d\n%d",&A,&B,&C);
    solution(A,B,C);
    printf("%d %d",A,B);
    return 0;
}
