#include <iostream>
#include <vector>
#include <stack>

using namespace std;

void countTile(vector<string>&floor, vector<vector<bool>>&visited, int x, int y){
    stack<pair<int,int>> s;
    s.push(make_pair(x,y));
    while(!s.empty()){
        pair<int,int> p = s.top();
        s.pop();
        visited[p.first][p.second] = true;
        if(floor[p.first][p.second] == '-' && p.second+1 < floor[0].size() && floor[p.first][p.second] == floor[p.first][p.second+1])
            s.push(make_pair(p.first, p.second + 1));
        else if(floor[p.first][p.second] == '|' && p.first+1 < floor.size() && floor[p.first][p.second] == floor[p.first+1][p.second])
            s.push(make_pair(p.first + 1, p.second));
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, ans = 0;
    cin >> N >> M;

    vector<vector<bool>> visited(N, vector<bool>(M));
    vector<string> floor(N);
    for(int i = 0; i < N; ++i)
        cin >> floor[i];

    for(int r = 0; r < N; ++r)
        for(int c = 0; c < M; ++c){
            if(visited[r][c])
                continue;
            ++ans;
            countTile(floor, visited, r, c);
        }

    cout << ans << "\n";
    return 0;
}
