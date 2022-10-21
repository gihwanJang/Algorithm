#include<cstdio>
#include<algorithm>
using namespace std;

struct Item{
    int w, v;
};

int main(int argc, char const *argv[]){
    int n, k, dp[101][100001];
    Item items[101];

    scanf("%d %d", &n, &k);
    for(int i = 1; i <= n; ++i)
        scanf("%d %d", &items[i].w, &items[i].v);

    for(int i = 1; i <= n; ++i)
        for(int j = 1; j <= k; ++j){
			 if (j >= items[i].w) dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - items[i].w] + items[i].v);
			 else dp[i][j] = dp[i - 1][j];
        }
                
    printf("%d\n", dp[n][k]);
    return 0;
}