#include<stdio.h>
#include<math.h>

void solution(int M, int N){
    int sum=0, min=10000;

    for(size_t i = M; i <= N; ++i){
        if(i==1) continue;
        bool flag = true;

        for(size_t j = 2; j <= sqrt(i); ++j){
            if(i % j == 0){
                flag = false;
                break;
            }
        }
        
        if(flag){
            sum += i;
            if(i < min) min = i;
        }
    }

    if(sum==0) printf("-1\n");
    else printf("%d\n%d\n", sum, min);
}

int main(int argc, char const *argv[]){
    int M, N;
    scanf("%d %d", &M, &N);

    solution(M, N);
    return 0;
}
