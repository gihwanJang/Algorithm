#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891
using namespace std;

struct edge{
    int e, v;
    edge(int E, int V): e(E), v(V){}
};

void dijkstra(vector<vector<edge>>&matrix, vector<int>&distance, int start){
    pair<int, int> curr, next;
    priority_queue<pair<int, int>> pq;

    distance[start] = 0;
    pq.push({0, start});

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < matrix[curr.second].size(); ++i){
            next = {curr.first + matrix[curr.second][i].v, matrix[curr.second][i].e};

            if(next.first < distance[matrix[curr.second][i].e]){
                distance[matrix[curr.second][i].e] = next.first;
                pq.push({next.first, next.second});
            }
        }
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, v, s, e;
    cin >> n >> m;

    vector<vector<edge>> matrix(n);
    while(m--){
        cin >> s >> e >> v;
        matrix[s-1].push_back(edge(e-1,v));
    }

    for(int i = 0; i < n; ++i){
        vector<int> distance(n, INF);

        dijkstra(matrix, distance, i);

        for(int j = 0; j < n; ++j)
            cout << (distance[j] == INF ? 0 : distance[j]) << " ";
        cout << "\n";
    }
    return 0;
}
