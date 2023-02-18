#include<iostream>
#include<math.h>

void solution(int n){
    for(int i = ceil((double)n/4); i > 0; --i)
        printf("long ");
    printf("int\n");
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);

    solution(n);
    return 0;
}
