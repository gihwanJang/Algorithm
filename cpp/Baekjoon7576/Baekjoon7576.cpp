#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int count_day(int n, int m, vector<vector<int>>&board){
    int res = 0;

    pair<int,int> curr;
    queue<pair<int,int>> que;
    // reset que
    for(int r = 0; r < m; ++r)
        for(int c = 0; c < n; ++c)
            if(board[r][c] == 1)
                que.push({r, c});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        // up
        if(curr.first > 0 && !board[curr.first-1][curr.second]){
            board[curr.first-1][curr.second] = board[curr.first][curr.second]+1;
            que.push({curr.first-1, curr.second});
        }
        // down
        if(curr.first < m-1 && !board[curr.first + 1][curr.second]){
            board[curr.first+1][curr.second] = board[curr.first][curr.second]+1;
            que.push({curr.first+1, curr.second});
        }
        // left
        if(curr.second > 0 && !board[curr.first][curr.second-1]){
            board[curr.first][curr.second-1] = board[curr.first][curr.second]+1;
            que.push({curr.first, curr.second-1});
        }
        // right
        if(curr.second < n-1 && !board[curr.first][curr.second+1]){
            board[curr.first][curr.second+1] = board[curr.first][curr.second]+1;
            que.push({curr.first, curr.second+1});
        }
    }

    for(int r = 0; r < m; ++r)
        for(int c = 0; c < n; ++c){
            if(board[r][c] == 0)
                return -1;
            if(res < board[r][c])
                res = board[r][c];
        }

    return res-1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, cnt = 0;
    cin >> n >> m;

    vector<vector<int>> board(m, vector<int>(n));
    for(int r = 0; r < m; ++r)
        for(int c = 0 ; c < n; ++c)
            cin >> board[r][c];

    cout << count_day(n, m, board) << "\n";    
    return 0;
}
