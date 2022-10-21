#include<cstdio>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    int n, s[1001], dp_ic[1001], dp_dc[1001], ans = 0;
    
    scanf("%d", &n);
    for(int i = 1; i <= n; ++i)
        scanf("%d", &s[i]);

    for(int i = 1; i <= n; ++i){
        dp_ic[i] = dp_dc[n - i +1] = 1;
        for(int j = 1; j < i; ++j){
            if(s[j] < s[i])
                dp_ic[i] = max(dp_ic[i], dp_ic[j] + 1);
            if(s[n - j +1 ] < s[n - i + 1])
                dp_dc[n - i + 1] = max(dp_dc[n - i + 1], dp_dc[n - j + 1] + 1);
        }
    }

    for(int i = 1; i <= n; ++i)
        ans = max(ans, dp_ic[i] + dp_dc[i]);
    
    printf("%d\n", ans - 1);
    return 0;
}
