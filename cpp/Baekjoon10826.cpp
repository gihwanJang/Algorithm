#include <iostream>
#include <algorithm>
using namespace std;

string string_plue(string long_str, string short_str){
    string ans = "";
    int carry = 0, a, b;

    for(int i = 1; i <= short_str.length(); ++i){
        a = long_str[long_str.length() - i] - 48;
        b = short_str[short_str.length() - i] - 48;
        ans += ((a + b + carry) % 10) + 48;
        carry = (a + b + carry) / 10;
    }

    for(int i = short_str.length() + 1; i <= long_str.length(); ++i){
        a = long_str[long_str.length() - i] - 48;
        ans += ((a + carry) % 10) + 48;
        carry = (a + carry) / 10;
    }
    if(carry != 0)
        ans += carry + 48;
        
    reverse(ans.begin(), ans.end());
    return ans;
} 

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string dp[10001];

    cin >> n;

    dp[0] = "0";
    dp[1] = "1";
    for(int i = 2; i <= n; ++i)
        dp[i] = string_plue(dp[i - 1], dp[i - 2]);

    cout << dp[n] << "\n";
    return 0;
}
