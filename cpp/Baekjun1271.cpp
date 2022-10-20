#include <cstdio>
using namespace std;

int n, m;

int main(int argc, char const *argv[]){
    scanf("%d %d", &n, &m);
    printf("%d\n%d\n", n / m, n % m);
    return 0;
}
