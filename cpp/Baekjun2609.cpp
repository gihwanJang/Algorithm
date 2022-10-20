#include<iostream>

int GCD(int a, int b){
    if(b == 0) return a;
    else return GCD(b, a%b);
}

int LCM(int a, int b, int gcd){
    return a*b/gcd;
}

int main(int argc, char const *argv[]){
    int a, b, gcd;
    scanf("%d %d", &a, &b);
    gcd = GCD(a,b);

    printf("%d\n%d\n", gcd, LCM(a, b, gcd));
    return 0;
}
