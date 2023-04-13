#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

#define INF 1234567891

using namespace std;

struct edge{
    int e, v;
    edge(int E, int V): e(E), v(V){}
};

pair<int,int> dijkstra(vector<vector<edge>>&tree, int start){
    pair<int,int> res = {start,0};
    pair<int,int> curr, next;
    vector<int> distance(tree.size());
    priority_queue<pair<int,int>> pq;
    pq.push({0, start});
    distance[start] = INF;

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < tree[curr.second].size(); ++i){
            next = {curr.first+tree[curr.second][i].v, tree[curr.second][i].e};

            if(!distance[next.second] && next.first > distance[next.second]){
                distance[next.second] = next.first;
                pq.push({next.first, next.second});
            }
        }
    }

    for(int i = 0; i < tree.size(); ++i)
        if(i != start)
            if(res.second < distance[i])
                res = {i, distance[i]};

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s, e, v, ans = 0;
    cin >> n;

    vector<vector<edge>> tree(n);
    while(--n){
        cin >> s >> e >> v;
        tree[s-1].push_back(edge(e-1,v));
        tree[e-1].push_back(edge(s-1,v));
    }

    ans = dijkstra(tree, dijkstra(tree, 0).first).second;
    
    cout << ans << "\n";
    return 0;
}
