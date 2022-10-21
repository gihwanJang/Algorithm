#include<stdio.h>

int solution(int A,int B,int C){
    if(C>B) return A/(C-B)+1;
    else return -1;
}

int main(int argc, char const *argv[]){
    int A,B,C;
    scanf("%d%d%d",&A,&B,&C);

    printf("%d\n",solution(A,B,C));
    return 0;
}