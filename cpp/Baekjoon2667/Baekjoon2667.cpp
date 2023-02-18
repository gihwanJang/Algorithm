#include <iostream>
#include <vector>
#include <utility>
#include <queue>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int dr[] = {1, 0, -1, 0};
    int dc[] = {0, 1, 0, -1};
    int N;
    cin >> N;

    vector<int> ans;
    vector<string> matrix(N);
    vector<vector<bool>> visited(N, vector<bool>(N));
    for(int i = 0; i < N; ++i)
        cin >> matrix[i];

    for(int r = 0; r < N; ++r)
        for(int c = 0; c < N; ++c){
            if(visited[r][c])
                continue;
            if(matrix[r][c] == '1'){
                int count = 0;
                queue<pair<int,int>> que;
                que.push(make_pair(r, c));

                while(!que.empty()){
                    pair<int,int> curr = que.front();
                    que.pop();
                    if(visited[curr.first][curr.second] == true)
                        continue;
                        
                    ++count;
                    visited[curr.first][curr.second] = true;

                    for(int i = 0; i < 4; ++i){
                        int next_r = curr.first + dr[i];
                        int next_c = curr.second + dc[i];

                        if (0 <= next_r && next_r < N && 0 <= next_c && next_c < N)
                            if(matrix[next_r][next_c] == '1' && !visited[next_r][next_c])
                                que.push(make_pair(next_r, next_c));
                    }
                }

                ans.push_back(count);
            }
        }

    sort(ans.begin(), ans.end());

    cout << ans.size() << "\n";
    for(int i = 0; i < ans.size(); ++i)
        cout << ans[i] << "\n";
    return 0;
}
