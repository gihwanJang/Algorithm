#include<iostream>
using namespace std;

void solution (int n, int r, int c){
    if((r / n) % 3 == 1 && (c / n) % 3 == 1)
        printf(" ");
    else if(n / 3 == 0)
        printf("*");
    else
        solution(n/3, r, c);
}

int main(){
    int n;
    scanf("%d", &n);

    for(int r = 0; r < n; ++r){
        for(int c = 0; c < n; ++c)
            solution(n, r, c);
        printf("\n");
    }
    return 0;
}