#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int rgbDistance(vector<vector<int>>&rgb){
    int res = 987654321, i;
    vector<vector<int>> dp(rgb.size(), vector<int>(3));
    
    for(int f = 0; f < 3; ++f){
        for(i = 0; i < 3; ++i){
            dp[0][i] = 987654321;
            if(f == i)
                dp[0][i] = rgb[0][i];
        }

        for(i = 1; i < rgb.size(); ++i){
            dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }

        for(i = 0; i < 3; ++i)
            if(i != f)
                res = min(res, dp[rgb.size()-1][i]);
    }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> rgb(n, vector<int>(3));
    for(int i = 0; i < n; ++i)
        cin >> rgb[i][0] >> rgb[i][1] >> rgb[i][2];

    cout << rgbDistance(rgb) << "\n";
    return 0;
}
