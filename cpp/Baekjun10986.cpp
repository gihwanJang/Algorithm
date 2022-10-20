#include<cstdio>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, num;
    long sum = 0, ans = 0, div[1001] = {0,};
    
    scanf("%d %d", &n, &m);
    for(int i = 0; i < n; ++i){
        scanf("%d", &num);
        sum += num;
        ++div[sum % m];
    }

    for (int i = 0; i < m; ++i)
		ans += div[i] * (div[i] - 1) / 2;

    printf("%ld\n", ans + div[0]);
    return 0;
}
