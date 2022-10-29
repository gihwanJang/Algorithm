#include<stdio.h>
void solution(int& H, int& M){
    M-=45;
    if(M<0){
        M+=60;
        --H;
        if(H<0) H+=24;
    }
}
int main(int argc, char const *argv[]){
    int H,M;
    scanf("%d %d",&H,&M);
    solution(H,M);
    printf("%d %d",H,M);
    return 0;
}
