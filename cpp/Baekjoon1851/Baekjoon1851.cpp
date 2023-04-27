#include <iostream>
#include <vector>

#define INF 1234567891

using namespace std;

struct edge{
    int s, e, v;
};

bool bellman_ford(vector<edge>&graph, int nodeSize){
    vector<int> distance(nodeSize);

    for(int i = 1; i < nodeSize; ++i)
        distance[i] = INF;
    
    for(int n = 0; n < nodeSize; ++n)
        for(int m = 0; m < graph.size(); ++m)
            if(distance[graph[m].e] > distance[graph[m].s] + graph[m].v){
                distance[graph[m].e] = distance[graph[m].s] + graph[m].v;
                
                if(n == nodeSize - 1)
                    return true;
            }

    return false;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n, m, w, s, e, v;
    cin >> T;

    while(T--){
        cin >> n >> m >> w;

        vector<edge> graph;
        for(int i = 0; i < m; ++i){
            cin >> s >> e >> v;
            graph.push_back({s-1, e-1, v});
            graph.push_back({e-1, s-1, v});
        }
        for(int i = 0; i < w; ++i){
            cin >> s >> e >> v;
            graph.push_back({s-1, e-1, -v});
        }

        cout << (bellman_ford(graph, n) ? "YES" : "NO") << "\n";
    }
    return 0;
}
