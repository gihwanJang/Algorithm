#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> graph[100001];
int visited[100001] = {0,};
int cnt = 0;

void dfs(int node){
    if(visited[node]) return;

    ++cnt;
    visited[node] = cnt;

    for (int i = 0; i < graph[node].size(); ++i)
		dfs(graph[node][i]);
}

int main(int argc, char const *argv[]){
    int n, m, root, u, v;

    scanf("%d %d %d", &n, &m, &root);
    for(int i = 0; i < m; ++i){
        scanf("%d %d", &u, &v);
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for (int i = 1; i <= n; i++)
		sort(graph[i].begin(), graph[i].end());

    dfs(root);

    for(int i = 1; i <= n; ++i)
        printf("%d\n", visited[i]);
    return 0;
}