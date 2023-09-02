#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF 1000000000

using namespace std;

void dijkstra(vector<vector<int>>&road, vector<int>&distance, int n, int x)
{
    pair<int,int> curr;
    distance[x] = 0;
    priority_queue<pair<int,int>> pq;

    for(int i = 0; i < road[x].size(); ++i)
        pq.push({-1, road[x][i]});

    while(!pq.empty())
    {
        curr = pq.top();
        pq.pop();

        distance[curr.second] = min(distance[curr.second], -curr.first);

        for(int i = 0; i < road[curr.second].size(); ++i)
            if(distance[road[curr.second][i]] == INF)
                pq.push({curr.first-1, road[curr.second][i]});
    }
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    bool hasAnswer = false;
    int n, m, k, x;
    cin >> n >> m >> k >> x;

    int s, e;
    vector<vector<int>> road(n);
    while(m--)
    {
        cin >> s >> e;
        road[s-1].push_back(e-1);
    }

    vector<int> distance(n, INF);
    dijkstra(road, distance, n, x-1);

    for(int i = 0; i < n; ++i)
    {
        if(distance[i] == k)
        {
            cout << i+1 << "\n";
            hasAnswer = true;
        }
    }

    if(!hasAnswer)
        cout << -1 << "\n";
    return 0;
}
