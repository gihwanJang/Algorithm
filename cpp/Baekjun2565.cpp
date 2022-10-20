#include<cstdio>
#include<algorithm>
#include<utility>
using namespace std;

int main(int argc, char const *argv[]){
    int n, dp[101], ans = 0;
    pair<int, int> line[101];

    scanf("%d", &n);
    for(int i = 1; i <= n; ++i)
        scanf("%d %d", &line[i].first, &line[i].second);

    sort(line+1, line+n+1);
    for(int i = 1; i <= n; ++i){
        dp[i] = 1;
        for(int j = 1; j < i; ++j)
            if(line[i].second > line[j].second)
                dp[i] = max(dp[i], dp[j] + 1);
        ans = max(ans, dp[i]);
    }

    printf("%d\n", n-ans);
    return 0;
}
