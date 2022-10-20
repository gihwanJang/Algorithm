#include<stdio.h>
#include<math.h>

int solution(int H, int W, int N){
    int x=ceil(double(N)/H);
    int y=N-H*(N/H);
    if(y==0)y=H;
    return y*100+x;
}

int main(int argc, char const *argv[]){
    int T, H, W, N;
    scanf("%d", &T);
    for(; T > 0; --T){
        scanf("%d %d %d", &H, &W, &N);

        printf("%d\n", solution(H, W, N));
    }
    return 0;
}
