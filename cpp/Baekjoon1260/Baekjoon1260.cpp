#include <iostream>
#include <vector>
#include <list>

using namespace std;

void bfs(const vector<vector<bool>>&graph, vector<bool>&visited, int node){
    list<int> queue;

    visited[node] = true;
    queue.push_back(node);

    while(!queue.empty()){
        node = queue.front();
        cout << node + 1 << " ";
        queue.pop_front();

        for(int i = 0; i < visited.size(); ++i)
            if(graph[node][i] && !visited[i]){
                visited[i] = true;
                queue.push_back(i);
            }
    }
}

void dfs(const vector<vector<bool>>&graph, vector<bool>&visited, int node){
    cout << node + 1 << " ";
    visited[node] = true;

    for(int i = 0; i < visited.size(); ++i)
        if(graph[node][i] && !visited[i])
            dfs(graph, visited, i);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, V, start, end;
    cin >> N >> M >> V;

    vector<vector<bool>> graph(N,vector<bool>(N, false));
    vector<bool> visited(N,false);

    while(M--){
        cin >> start >> end;
        graph[start - 1][end - 1] = true;
        graph[end - 1][start - 1] = true;
    }

    dfs(graph, visited, V - 1);
    cout << "\n";
    fill(visited.begin(), visited.end(), false);
    bfs(graph, visited, V - 1);
    return 0;
}