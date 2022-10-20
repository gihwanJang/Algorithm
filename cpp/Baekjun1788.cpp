#include <cstdio>
#include <cmath>
using namespace std;

int main(int argc, char const *argv[]){
    int n, a = 1, b = 1, c = 1;

    scanf("%d", &n);
    for(int i = 2; i < abs(n); ++i, a = b, b = c)
        c = (a % 1000000000 + b % 1000000000) % 1000000000;
    
    if(n == 0){
        printf("0\n");
        c = 0;
    }
    else if(n < 0 && n % 2 == 0) printf("-1\n");
    else printf("1\n");
    printf("%d\n", c);
    return 0;
}
