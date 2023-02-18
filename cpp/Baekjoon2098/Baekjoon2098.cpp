#include <algorithm>
#include <iostream>
#include <vector>
#define INF 1e9

using namespace std;

int tsp(vector<vector<int>>&graph, vector<vector<int>>&dp, int n, int end, int now, int visited){
    if(visited == end){
        if(graph[now][0] > 0)
            return graph[now][0];
        return INF;
    }

    if(dp[now][visited] != 0)
        return dp[now][visited];

    dp[now][visited] = INF;

    for(int i = 0; i < n; ++i){
        if(graph[now][i] == 0)
            continue;
        if(visited & (1 << i))
            continue;

		dp[now][visited] = min(dp[now][visited], graph[now][i] + tsp(graph, dp, n, end, i, visited | 1 << i)); 
    }

    return dp[now][visited];
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, end;
    cin >> n;
    end = (1 << n) - 1;

    vector<vector<int>> dp(n, vector<int>(1 << n));
    vector<vector<int>> graph(n, vector<int>(n));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            cin >> graph[r][c];

    cout << tsp(graph, dp, n, end, 0, 1) << "\n";
    return 0;
}
