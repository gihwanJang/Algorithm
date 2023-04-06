#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;
//ㅗ
int shape1(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r][c+1] + board[r][c+2] + board[r-1][c+1];
}
//ㅜ
int shape2(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r][c+1] + board[r][c+2] + board[r+1][c+1];
}
//ㅓ
int shape3(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r+1][c] + board[r+2][c] + board[r+1][c-1];
}
//ㅏ
int shape4(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r+1][c] + board[r+2][c] + board[r+1][c+1];
}

int blocking(vector<vector<int>>&board, vector<vector<bool>>&visited, int r, int c, int depth){
    if(depth == 4) return board[r][c];

    int res = 0;

    if(r < board.size()-1 && !visited[r+1][c]){
        visited[r+1][c] = true;
        res = max(res, board[r][c]+blocking(board,visited,r+1,c,depth+1));
        visited[r+1][c] = false;
    }
    if(c > 0 && !visited[r][c-1]){
        visited[r][c-1] = true;
        res = max(res, board[r][c]+blocking(board,visited,r,c-1,depth+1));
        visited[r][c-1] = false;
    }
    if(c < board[0].size()-1 && !visited[r][c+1]){
        visited[r][c+1] = true;
        res = max(res, board[r][c]+blocking(board,visited,r,c+1,depth+1));
        visited[r][c+1] = false;
    }
    return res;
}

int tetromino(int n,int m, vector<vector<int>>&board){
    int res = 0;
    vector<vector<bool>> visited(n, vector<bool>(m));

    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c){
            visited[r][c] = true;
            res = max(res, blocking(board, visited, r, c, 1));
            visited[r][c] = false;

            if(r > 0 && c+2 < board[0].size())
                res = max(res, shape1(board,r,c));
            if(r+1 < board.size() && c+2 < board[0].size())
                res = max(res, shape2(board,r,c));
            if(r+2 < board.size() && c > 0)
                res = max(res, shape3(board,r,c));
            if(r + 2 < board.size() && c+1 < board[0].size())
                res = max(res, shape4(board,r,c));
        }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> board(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            cin >> board[r][c];

    cout << tetromino(n,m,board) << "\n";
    return 0;
}
