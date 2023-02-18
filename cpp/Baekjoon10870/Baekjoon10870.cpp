#include<iostream>

int solution(int n){
    if(n <= 1) return n;
    int fibo = solution(n-1) + solution(n-2);
    return fibo;
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);

    printf("%d\n", solution(n));
    return 0;
}
