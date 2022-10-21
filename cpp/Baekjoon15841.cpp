#include <cstdio>
#include <string>
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
    int n;
    string dp[491];

    dp[1] = dp[2] = "1";
    for(int i = 3; i < 491; ++i)
        dp[i] = string_plue(dp[i - 1], dp[i - 2]);
    
    while(true){
        scanf("%d", &n);
        if(n == -1) break;
        printf("Hour %d: %s cow(s) affected\n", n, dp[n].c_str());
    }
    return 0;
}
