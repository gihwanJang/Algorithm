#include<stdio.h>
#include<math.h>

void solution(int M, int N){
    for(int i = M; i<=N; ++i){
        if(i == 1)continue;
        bool flag = true;

        for(size_t j = 2; j <= sqrt(i); ++j)
            if(i % j == 0){
                flag = false;
                break;
            }
        
        if(flag)printf("%d\n",i);
    }
}

int main(int argc, char const *argv[]){
    int M, N;
    scanf("%d %d", &M, &N);

    solution(M, N);
    return 0;
}
