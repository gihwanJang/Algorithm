#include <cstdio>
#include <utility>
using namespace std;

int main(int argc, char const *argv[]){
    int n, m, ans = 10000000;
    pair<int, int> dp[101][101];
    
    scanf("%d %d", &n, &m);
    for(int i = 1; i <= n; ++i)
        scanf("%d", &dp[0][i].first);
    for(int i = 1; i <= n; ++i)
        scanf("%d", &dp[0][i].second);
    return 0;
}
