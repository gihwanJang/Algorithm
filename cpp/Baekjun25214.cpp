#include <stdio.h>

int main(int argc, char const *argv[]){
    int n, num, min = 2000000000, ans = 0;

    scanf("%d", &n);
    while(n--){
        scanf("%d", &num);
        if(min > num) min = num;
        if(ans < num - min) ans = num - min;
        printf("%d ", ans);
    }
    
    return 0;
}
