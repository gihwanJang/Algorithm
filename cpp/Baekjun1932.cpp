#include<iostream>
using namespace std;

int main(int argc, char const *argv[]){
    int n, k, ans, table[501][501];
    scanf("%d %d", &n, &k);
    table[0][0] = ans = k;

    for(int i = 1; i < n; ++i)
        for(int j = 0; j <= i; ++j){
            scanf("%d", &k);
            if(j == 0) table[i][j] = table[i - 1][j] + k;
            else if(j == i) table[i][j] = table[i - 1][j - 1] + k;
            else table[i][j] = max(table[i - 1][j - 1] + k, table[i - 1][j] + k);
        }

    for(int i = 0; i < n ; ++i)
        if(table[n - 1][i] > ans)
            ans = table[n - 1][i];

    printf("%d\n", ans);
    return 0;
}
