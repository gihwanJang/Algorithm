#include<stdio.h>
#include<math.h>

int solution(int A, int B, int V){
    return ceil(double(V-B)/(A-B));
}

int main(int argc, char const *argv[]){
    int A, B, V;
    scanf("%d %d %d", &A, &B, &V);

    printf("%d\n", solution(A, B, V));
    return 0;
}
