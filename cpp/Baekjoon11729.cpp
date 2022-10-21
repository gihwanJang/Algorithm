#include<iostream>
#include<math.h>

void solution(int k, int from, int by, int to){
    if(k == 1){
        printf("%d %d\n", from, to);
        return;
    }
    solution(k-1, from, to, by);
    printf("%d %d\n", from, to);
    solution(k-1, by, from, to);
}

int main(int argc, char const *argv[]){
    int k;
    scanf("%d", &k);

    printf("%d\n", int(pow(2,k)-1));
    solution(k, 1, 2, 3);
    return 0;
}
