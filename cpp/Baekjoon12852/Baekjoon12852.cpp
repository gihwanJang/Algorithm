#include <iostream>
#include <vector>

using namespace std;

struct history{
    int cnt;
    int prev;
};

void makeOne(int n, vector<history>&dp){
    dp[1].cnt = 0;
    dp[1].prev = 1;

    for(int i = 1; i < n; ++i){
        if(i * 3 <= n)
            if(dp[i*3].prev == 0 || dp[i*3].cnt > dp[i].cnt+1){
                dp[i*3].cnt = dp[i].cnt+1;
                dp[i*3].prev = i;
            }
        
        if(i * 2 <= n)
            if(dp[i*2].prev == 0 || dp[i*2].cnt > dp[i].cnt+1){
                dp[i*2].cnt = dp[i].cnt+1;
                dp[i*2].prev = i;
            }    

        if(dp[i+1].prev == 0 || dp[i+1].cnt > dp[i].cnt+1){
            dp[i+1].cnt = dp[i].cnt+1;
            dp[i+1].prev = i;
        }
    }

    return;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<history> dp(n + 1);
    makeOne(n, dp);
    
    int curr = n;
    cout << dp[n].cnt << "\n";
    while(curr != 1){
        cout << curr << " ";
        curr = dp[curr].prev;
    }
    cout << 1 << "\n";
    return 0;
}