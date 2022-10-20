#include<iostream>

int solution(int n){
    int c = 0;

    for(int i = 1; i < 55; ++i){
        int tmp = n - i;
        for(int j = tmp; j > 0; j/=10)
            tmp += j % 10;
        if(tmp == n)
            c = n - i;
    }

    return c;
}

int main(){
    int n;
    scanf("%d", &n);

    printf("%d\n", solution(n));
    return 0;
}