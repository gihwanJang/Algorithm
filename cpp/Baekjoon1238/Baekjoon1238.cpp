#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF (1234567891)

using namespace std;

struct edge {
    int end, val;

    edge(int E, int V): end(E), val(V){}

    bool operator<(const edge&e)const{
        return this->val > e.val;
    }
};

void dijkstra(vector<vector<edge>>&graph, vector<int>&distance, int start){
    priority_queue<edge> pq;
    edge curr(start, 0);
    edge next(0, 0);

    pq.push(curr);
    distance[start] = 0;

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = curr.val + graph[curr.end][i].val;

            if(distance[next.end] > next.val){
                distance[next.end] = next.val;
                pq.push(next);
            }
        }
    }
}

int getLongestPath(vector<vector<edge>>&graph, int goal){
    int long_path = 0;
    vector<int> goal_to_home(graph.size(), INF);

    dijkstra(graph, goal_to_home, goal);
    for(int i = 0; i < graph.size(); ++i){
        vector<int> home_to_goal(graph.size(), INF);
        dijkstra(graph, home_to_goal, i);

        long_path = max(long_path, home_to_goal[goal] + goal_to_home[i]);
    }

    return long_path;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, x, s, e, v;
    cin >> n >> m >> x;

    vector<vector<edge>> graph(n);
    while(m--){
        cin >> s >> e >> v;
        graph[s-1].push_back(edge(e-1, v));
    }

    cout << getLongestPath(graph, x-1) << "\n";
    return 0;
}
