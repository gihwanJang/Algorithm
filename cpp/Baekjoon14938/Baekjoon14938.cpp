#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891

using namespace std;

struct edge{
    int end, val;

    edge(int e, int v): end(e), val(v){}

    bool operator<(const edge&e)const{
        return this->val < e.val;
    }
};

int farming(vector<int>&items, vector<vector<edge>>&graph, int m, int start){
    int res = 0;
    edge curr(start, 0);
    edge next(0, 0);
    vector<int> distance(items.size(), INF);
    priority_queue<edge> pq;

    pq.push(curr);
    distance[start] = 0;
    
    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < graph[curr.end].size(); ++i){
            next.end = graph[curr.end][i].end;
            next.val = graph[curr.end][i].val + curr.val;

            if(distance[next.end] > next.val){
                distance[next.end] = next.val;
                pq.push(next);
            }
        }
    }

    for(int i = 0; i < items.size(); ++i)
        if(distance[i] <= m)
            res += items[i];

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, r, ans = 0;
    cin >> n >> m >> r;

    vector<int> items(n);
    for(int i = 0; i < n; ++i)
        cin >> items[i];

    vector<vector<edge>> graph(n);
    while(r--){
        int s, e, v;
        cin >> s >> e >> v;

        graph[s-1].push_back(edge(e-1, v));
        graph[e-1].push_back(edge(s-1, v));
    }

    for(int i = 0; i < n; ++i)
        ans = max(ans, farming(items, graph, m, i));

    cout << ans << "\n";
    return 0;
}
