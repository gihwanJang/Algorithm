#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891

using namespace std;

struct edge{
    int end, value;

    edge(int e, int v): end(e), value(v){}

    bool operator<(const edge e) const {
        return this->value > e.value;
    }
};

int Dijkstra(vector<vector<edge>>&graph, int s, int e){
    edge curr(s, 0);
    edge next (0, 0);
    vector<int> distance(graph.size(), INF);
    priority_queue<edge> pq;

    distance[s] = 0;
    pq.push(curr);

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        if(curr.end == e)
            return distance[e];

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.value = curr.value + graph[curr.end][i].value;

            if(distance[next.end] > next.value){
                distance[next.end] = next.value;
                pq.push(edge(next.end, next.value));
            }
        }
    }

    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e, v;
    cin >> n >> m;

    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e >> v;
        graph[s-1].push_back(edge(e-1, v));
    }

    cin >> s >> e;

    cout << Dijkstra(graph, s-1, e-1);
    return 0;
}
