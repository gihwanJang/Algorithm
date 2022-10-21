#include<iostream>

long table[101];

int main(int argc, char const *argv[]){
    int T, n;

    table[0] = 1;
    table[1] = 1;
    table[2] = 1;
    table[3] = 2;
    table[4] = 2;

    for(scanf("%d", &T); T>0; --T){
        scanf("%d", &n);
        for(int i = 5; i < n; ++i)
            table[i] = table[i-1] + table[i-5];
        printf("%ld\n", table[n-1]);
    }
    return 0;
}
