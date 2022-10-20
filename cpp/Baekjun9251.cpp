#include<iostream>
using namespace std;

int max_three(int a, int b, int c){
    if(a > b){
        if(a > c) return a;
        else return c;
    }
    else{
        if(b > c) return b;
        else return c;
    }
}

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int dp[1001][1001], i, j;
    string s1,s2;
    cin >> s1 >> s2;

    for(i = 1; i <= s1.length(); ++i)
        for(j = 1; j <= s2.length(); ++j)
            dp[i][j] = dp[i][j] = max_three(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1] + (s1[i-1] == s2[j-1]));
    
    cout << dp[i - 1][j - 1] << "\n";
    return 0;
}
