#include<iostream>

int solution(int n){
    if(n <= 1) return 1;
    return n * solution(n-1);
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);

    printf("%d\n", solution(n));
    return 0;
}
