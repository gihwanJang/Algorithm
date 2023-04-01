#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int BFS(vector<vector<bool>>&matrix, int curr){
    int res = 1;
    pair<int,int> node;
    vector<int> visited(matrix.size());
    queue<pair<int,int>> que;
    que.push({curr, 0});

    while(!que.empty()){
        node = que.front();
        que.pop();
        visited[node.first] = node.second;
        if(node.first == curr)
            visited[node.first] = -1;

        for(int i = 1; i <= matrix.size(); ++i)
            if(matrix[node.first][i] && !visited[i])
                que.push({i, node.second+1});
    }

    for(int i = 1; i <= matrix.size(); ++i)
        res += visited[i];

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    pair<int,int> ans = {0,1234567891};
    int n, m, e1, e2;
    cin >> n >> m;

    vector<vector<bool>> matrix(n+1, vector<bool>(n+1));
    while(m--){
        cin >> e1 >> e2;
        matrix[e1][e2] = true;
        matrix[e2][e1] = true;
    }

    for(int i = 1; i <= n; ++i){
        e1 = BFS(matrix,i);
        
         if(ans.second > e1)
            ans = {i, e1};
    }

    cout << ans.first << "\n";
    return 0;
}
