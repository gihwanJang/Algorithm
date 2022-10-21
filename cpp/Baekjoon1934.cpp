#include<iostream>

int GCD(int a, int b){
    if(b == 0) return a;
    else return GCD(b, a%b);
}

int LCM(int a, int b){
    return a * b / GCD(a, b);
}

int main(int argc, char const *argv[]){
    int T, a, b;
    scanf("%d", &T);
    for(; T > 0; --T){
        scanf("%d %d", &a, &b);
        
        printf("%d\n", LCM(a, b));
    }
    return 0;
}
