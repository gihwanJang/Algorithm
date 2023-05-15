#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int maxSaftyArea(vector<vector<int>> board, vector<pair<int,int>>&virus){
    int maxSize = 0;
    pair<int,int> p;
    queue<pair<int,int>> que;
    
    for(int i = 0; i < virus.size(); ++i)
        que.push(virus[i]);

    while(!que.empty()){
        p = que.front();
        que.pop();

        if(p.first+1 < board.size() && !board[p.first+1][p.second]){
            board[p.first+1][p.second] = 2;
            que.push({p.first+1, p.second});
        }
        if(p.first > 0 && !board[p.first-1][p.second]){
            board[p.first-1][p.second] = 2;
            que.push({p.first-1, p.second});
        }
        if(p.second+1 < board[0].size() && !board[p.first][p.second+1]){
            board[p.first][p.second+1] = 2;
            que.push({p.first, p.second+1});
        }
        if(p.second > 0 && !board[p.first][p.second-1]){
            board[p.first][p.second-1] = 2;
            que.push({p.first, p.second-1});
        }
    }

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board[0].size(); ++c)
            if(!board[r][c])
                ++maxSize;

    return maxSize;
}

int saftyArea(vector<vector<int>>&board, vector<pair<int,int>>&virus, int r_c, int depth){
    if(depth == 3)
        return maxSaftyArea(board, virus);

    int res = 0;

    for(int r = r_c; r < board.size(); ++r)
        for(int c = 0; c < board[0].size(); ++c)
            if(!board[r][c]){
                board[r][c] = 1;
                res = max(res, saftyArea(board, virus, r, depth+1));
                board[r][c] = 0;
            }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<pair<int,int>> virus;
    vector<vector<int>> board(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c){
            cin >> board[r][c];

            if(board[r][c] == 2)
                virus.push_back({r, c});
        }

    cout << saftyArea(board, virus, 0, 0) << "\n";
    return 0;
}
