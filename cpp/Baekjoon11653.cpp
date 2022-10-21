#include<stdio.h>

void solution(int N){
    if(N==1) return;

    for(int i = 2; i<=N; ++i)
        if(N % i == 0){
            printf("%d\n",i);
            N/=i;
            i=1;
        }
}

int main(int argc, char const *argv[]){
    int N;
    scanf("%d", &N);

    solution(N);
    return 0;
}
