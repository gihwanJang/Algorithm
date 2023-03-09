#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void LCS(vector<vector<int>>&dp, string s1, string s2){
    for(int i = 1; i <= s1.size(); ++i)
        for(int j = 1; j <= s2.size(); ++j){
            if(s1[i-1] == s2[j-1])
                dp[i][j] = dp[i-1][j-1] + 1;
            else
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        }
}

string makeSeqStr(vector<vector<int>>&dp, int l1, int l2, string s1){
    string s;

    while(dp[l1][l2] > 0){
        if(dp[l1][l2] == dp[l1][l2-1])
            --l2;
        else if(dp[l1][l2] == dp[l1-1][l2])
            --l1;
        else if(dp[l1][l2] - 1 == dp[l1-1][l2-1]){
            s.push_back(s1[l1-1]);
            --l1;
            --l2;
        }
    }

    reverse(s.begin(), s.end());
    
    return s;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s1, s2;
    cin >> s1 >> s2;

    vector<vector<int>> dp(s1.size()+1, vector<int>(s2.size()+1));
    LCS(dp, s1, s2);

    cout << dp[s1.size()][s2.size()] << "\n";

    if(dp[s1.size()][s2.size()] > 0)
        cout << makeSeqStr(dp, s1.size(), s2.size(), s1) << "\n";
    return 0;
}
