#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int T, a, b;
    char coma;

    scanf("%d", &T);
    while(T--){
        scanf("%d %c %d", &a, &coma, &b);
        printf("%d\n", a + b);
    }
    return 0;
}
