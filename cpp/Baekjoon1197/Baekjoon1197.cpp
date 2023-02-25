#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

struct edge{
    int v1, v2, val;
};

bool cmp(edge e1, edge e2){
    return e1.val < e2.val;
}

int find(vector<int>&cycleTable, int x) {
    if(cycleTable[x] == x) return x;
    return find(cycleTable, cycleTable[x]);
}

int mst(vector<edge>&edges, vector<int>&cycleTable){
    sort(edges.begin(), edges.end(), cmp);

    int ans = 0;

    for(int i = 0, cnt = 2; cnt < cycleTable.size(); ++i){
        int root1 = find(cycleTable, edges[i].v1);
        int root2 = find(cycleTable, edges[i].v2);
        
        if(root1 != root2){
            ans += edges[i].val;
            cycleTable[root2] = root1;
            ++cnt;
        }
    }

    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int v, e;
    cin >> v >> e;

    vector<edge> edges(e);
    for(int i = 0; i < e; ++i)
        cin >> edges[i].v1 >> edges[i].v2 >> edges[i].val;

    vector<int> cycleTable(v+1);
    for(int i = 1; i <= v; ++i)
        cycleTable[i] = i;

    cout << mst(edges, cycleTable) << "\n";
    return 0;
}
