#include <cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int T, a, b, k;

    scanf("%d", &T);
    for(; T > 0; --T){
        scanf("%d %d", &a, &b);
        k = a;
        for(int i = 1; i < b % 4 + 4; ++i, k %= 10)
            k *= a;
        printf("%d\n", k ? k : 10);
    }
    return 0;
}
