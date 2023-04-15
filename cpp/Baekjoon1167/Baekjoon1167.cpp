#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct edge{
    int e, v;
    edge(int E, int V): e(E), v(V){}
};

pair<int,int> dijkstra(vector<vector<edge>>&tree, int start){
    pair<int,int> curr, next;
    vector<int> distance(tree.size());
    priority_queue<pair<int,int>> pq;
    pq.push({0, start});
    distance[start] = 1234567891;

    while(!pq.empty()){
        curr = pq.top();
        pq.pop();

        for(int i = 0; i < tree[curr.second].size(); ++i){
            next = {curr.first + tree[curr.second][i].v, tree[curr.second][i].e};

            if(!distance[next.second] && distance[next.second] < next.first){
                distance[next.second] = next.first;
                pq.push({next.first, next.second});
            }
        }
    }

    for(int i = 0; i < tree.size(); ++i)
        if(i != start)
            if(curr.second < distance[i])
                curr = {i, distance[i]};

    return curr;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s, e, v;
    cin >> n;
    vector<vector<edge>> tree(n);
    while(n--){
        cin >> s;

        while(true){
            cin >> e;
            if(e == -1)
                break;
            cin >> v;

            tree[s-1].push_back(edge(e-1,v));
        }
    }
    
    pair<int,int> ans = dijkstra(tree, 0);
    ans = dijkstra(tree, ans.first);
    cout << ans.second << "\n";
    return 0;
}
