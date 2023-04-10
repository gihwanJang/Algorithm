#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void DFS(vector<vector<int>>&graph, vector<int>&parent, int curr){
    for(int i = 0; i < graph[curr].size(); ++i)
        if(!parent[graph[curr][i]]){
            parent[graph[curr][i]] = curr;
            DFS(graph, parent, graph[curr][i]);
        }                
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s, e;
    cin >> n;

    vector<int> parent(n+1);
    vector<vector<int>> graph(n+1);
    while(--n){
        cin >> s >> e;
        graph[s].push_back(e);
        graph[e].push_back(s);
    }

    parent[1] = 1;
    DFS(graph, parent, 1);
    for(int i = 2; i < parent.size(); ++i)
        cout << parent[i] << "\n";
    return 0;
}
