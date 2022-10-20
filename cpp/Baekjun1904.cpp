#include<iostream>

int main(int argc, char const *argv[]){
    int n, mod = 15746;
    scanf("%d", &n);
    int table[n];
    table[0] = 1;
    table[1] = 2;

    for(int i = 2; i < n; ++i)
        table[i] = (table[i-1] + table[i-2]) % mod;

    printf("%d\n", table[n-1]);
    return 0;
}
