#include<cstdio>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    int n, s[1001], dp[1001], ans = 0;
    
    scanf("%d", &n);
    for(int i = 1; i <= n; ++i)
        scanf("%d", &s[i]);

    for(int i = 1; i <= n; ++i){
        dp[i] = s[i];
        for(int j = 1; j <=i; ++j)
            if(s[j] < s[i])
                dp[i] = max(dp[i], dp[j] + s[i]);
		if(ans < dp[i]) ans = dp[i];
    }

    printf("%d\n", ans);
    return 0;
}