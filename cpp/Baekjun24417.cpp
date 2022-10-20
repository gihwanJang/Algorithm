#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, a = 1, b = 1, c;
    scanf("%d", &n);

    for(int i = 2; i < n; ++i, a = b, b = c)
        c = (a % 1000000007 + b % 1000000007) % 1000000007;

    printf("%d %d\n", c, n - 2);
    return 0;
}
