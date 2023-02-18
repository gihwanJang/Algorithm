#include<stdio.h>

int main(int argc, char const *argv[]){
    int n, ans, num;
    scanf("%d %d", &n, &num);

    int table[n];
    table[0] = ans = num;
    for(int i = 1; i < n; ++i){
        scanf("%d", &num);
        table[i] = num > num+table[i-1] ? num : num+table[i-1];
        ans = ans > table[i] ? ans : table[i];
    }

    printf("%d\n", ans);
    return 0;
}
