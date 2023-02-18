#include<iostream>
using namespace std;

int main(int argc, char const *argv[]){
    int n, mod = 1000000000;
    long ans = 0, table[101][11];
    scanf("%d", &n);
    table[1][0] = 0;
    fill(table[1]+1, table[1]+10, 1);

    for(int i = 2; i <= n; ++i)
        for(int j = 0; j <= 9; ++j){
            if(j == 0) table[i][j] = table[i - 1][j + 1];
            else if(j == 9) table[i][j] = table[i - 1][j - 1];
            else table[i][j] = (table[i - 1][j - 1] + table[i - 1][j + 1]) % mod;
        }

    for(int i = 0; i <= 9; ++i)
        ans += table[n][i];

    printf("%ld\n", ans % mod);
    return 0;
}