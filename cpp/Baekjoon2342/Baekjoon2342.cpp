#include <algorithm>
#include <iostream>
#include <vector>

#define INF 2000000000

using namespace std;

int getForce(int curr, int next)
{
    if(curr == next)
        return 1;
    if(curr == 0)
        return 2;
    if((curr + 1) % 4 == next % 4 || (curr - 1) % 4 == next % 4)
        return 3;
    return 4;
}

int getMinimumForce(vector<int>&steps)
{
    int minimum = INF;
    int size = steps.size();
    vector<vector<vector<int>>> dp(size, vector<vector<int>>(5, vector<int>(5, INF)));

    dp[0][0][steps[0]] = 2;
    dp[0][steps[0]][0] = 2;

    for(int i = 0; i < size-1; ++i)
        for(int l = 0; l < 5; ++l)
            for(int r = 0; r < 5; ++r)
                if(dp[i][l][r] != INF)
                {
                    dp[i+1][l][steps[i+1]] = min(dp[i][l][r] + getForce(r, steps[i+1]), dp[i+1][l][steps[i+1]]);
                    dp[i+1][steps[i+1]][r] = min(dp[i][l][r] + getForce(l, steps[i+1]), dp[i+1][steps[i+1]][r]);
                }

    for(int l = 0; l < 5; ++l)
        for(int r = 0; r < 5; ++r)
            if(dp[size-1][l][r] != INF)
                minimum = min(minimum, dp[size-1][l][r]);

    return minimum;
}
 
int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    vector<int> steps;

    while(1)
    {
        cin >> n;
        if(!n) break;
        steps.push_back(n);
    }

    cout << getMinimumForce(steps) << "\n";
    return 0;
}
