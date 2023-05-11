#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF (1234567891)

using namespace std;

struct edge {
    int end, val;

    edge(int e, int v): end(e), val(v){}

    bool operator<(const edge&e)const{
        return this->val > e.val;
    }
};

void dijkstra(vector<pair<int,int>>&distance, vector<vector<edge>>&graph, int s, int e){
    edge curr(s,0), next(0,0);
    priority_queue<edge> pq;

    for(int i = 0; i < graph.size(); ++i){
        distance[i].first = i;
        distance[i].second = INF;
    }

    distance[s].second = 0;
    pq.push(curr);

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        if(curr.end == e)
            return;

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = graph[curr.end][i].val + curr.val;

            if(distance[next.end].second > next.val){
                distance[next.end].first = curr.end;
                distance[next.end].second = next.val;

                pq.push(next);
            }
        }
    }
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e, v;
    cin >> n >> m;

    vector<int> stack;
    vector<pair<int,int>> distance(n);
    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e >> v;
        graph[s-1].push_back(edge(e-1, v));
    }

    cin >> s >> e;

    dijkstra(distance, graph, s-1, e-1);

    stack.push_back(e-1);
    while(stack.back() != distance[stack.back()].first)
        stack.push_back(distance[stack.back()].first);

    cout << distance[e-1].second << "\n";
    cout << stack.size() << "\n";
    while(!stack.empty()){
        cout << stack.back()+1 << " ";
        stack.pop_back();
    }
    cout << "\n";
    return 0;
}
