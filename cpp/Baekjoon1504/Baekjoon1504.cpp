#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF (1234567891)

using namespace std;

struct edge{
    int end, val;

    edge(int e, int v): end(e), val(v){}

    bool operator<(const edge&e)const{
        return this->val > e.val;
    }
};

void dijkstra(vector<vector<edge>>&graph, vector<int>&distance, int s){
    edge curr(s, 0);
    edge next(0, 0);
    priority_queue<edge> pq;

    for(int i = 0; i < graph.size(); ++i)
        distance[i] = INF;

    distance[s] = 0;
    pq.push(curr);

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = curr.val + graph[curr.end][i].val;

            if(distance[next.end] > next.val){
                distance[next.end] = next.val;
                pq.push(edge(next.end, next.val));
            }
        }
    }
}

long shortestPath(vector<vector<edge>>&graph, int n1, int n2){
    vector<int> distance(graph.size());

    long res;
    long route_n1_n2;
    long route_n2_n1;

    dijkstra(graph, distance, 0);
    route_n1_n2 = distance[n1];
    route_n2_n1 = distance[n2];

    dijkstra(graph, distance, n1);
    route_n1_n2 += distance[n2];
    route_n2_n1 += distance[n2];

    dijkstra(graph, distance, graph.size()-1);
    route_n1_n2 += distance[n2];
    route_n2_n1 += distance[n1];

    res = min(route_n1_n2, route_n2_n1);
    return (res >= INF ? -1 : res);
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e, v, n1, n2;
    cin >> n >> m;

    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e>> v;
        graph[s-1].push_back(edge(e-1, v));
        graph[e-1].push_back(edge(s-1, v));
    }

    cin >> n1 >> n2;

    cout << shortestPath(graph, n1-1, n2-1) << "\n";
    return 0;
}
