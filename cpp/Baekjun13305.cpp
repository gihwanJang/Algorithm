#include<cstdio>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    int n, d[100001];
    long cost = 0, c[100001] = {2000000000,};

    scanf("%d", &n);
    for(int i = 1; i < n; ++i)
        scanf("%d", &d[i]);
    for(int i = 1; i < n; cost += c[i] * d[i++]){
        scanf("%ld", &c[i]);
        c[i] = min(c[i-1], c[i]);
    }
    scanf("%d", &c[0]);
        
    printf("%ld\n", cost);
    return 0;
}
