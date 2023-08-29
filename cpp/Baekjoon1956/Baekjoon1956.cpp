#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF 1000000000

using namespace std;

int getMinimumCycle(vector<vector<int>>&graph, int v, int e)
{
    int minimum = INF;
    
    for(int i = 0; i < v; ++i)
        for(int j = 0; j < v; ++j)
            for(int k = 0; k < v; ++k)
                graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k]);

    for(int i = 0; i < v; ++i)
        minimum = min(graph[i][i], minimum);

    return minimum == INF ? -1  : minimum;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int v, e, start, end, value;
    cin >> v >> e;

    vector<vector<int>> graph(v, vector<int>(v, INF));
    for(int i = 0; i < e; ++i)
    {
        cin >> start >> end >> value;
        graph[start-1][end-1] = value;
    }

    cout << getMinimumCycle(graph, v, e) << "\n";
    return 0;
}
