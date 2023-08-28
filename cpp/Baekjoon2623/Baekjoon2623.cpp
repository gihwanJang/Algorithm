#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool topologySort(vector<vector<bool>>&graph, vector<int>&degree, vector<int>&ans, int n)
{
    int curr;
    queue<int> que;

    for(int i = 1; i <= n; ++i)
        if(!degree[i])
            que.push(i);

    for(int i = 0; i < n; ++i)
    {
        if(que.empty())
            return false;

        curr = que.front();
        que.pop();
        ans.push_back(curr);

        for(int j = 1; j <= n; ++j)
            if(graph[curr][j])
            {
                --degree[j];

                if(!degree[j])
                    que.push(j);
            }
    }

    return true;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    int count, prev, curr;
    vector<int> ans;
    vector<int> degree(n+1);
    vector<vector<bool>> graph(n+1, vector<bool>(n+1));
    for(int i = 0; i < m; ++i)
    {
        cin >> count;
        cin >> prev;
        for(int j = 1; j < count; ++j)
        {
            cin >> curr;

            if(!graph[prev][curr])
            {
                graph[prev][curr] = true;
                ++degree[curr];
            }

            prev = curr;
        } 
    }

    if(topologySort(graph, degree, ans, n))
        for(int i = 0; i < n; ++i)
            cout << ans[i] << "\n";
    else
        cout << 0 << "\n";
    return 0;
}
