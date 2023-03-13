#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

queue<int> que;

int find_maximum(vector<vector<vector<int>>>&board, int depth);

int move_up(vector<vector<vector<int>>>&board, int depth){
    for(int c = 0; c < board.size(); ++c){
        for(int r = 0; r < board.size(); ++r)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int r = 0; r < board.size(); ++r){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }

    return find_maximum(board, depth);
}

int move_down(vector<vector<vector<int>>>&board, int depth){
    for(int c = 0; c < board.size(); ++c){
        for(int r = board.size()-1; r > -1; --r)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int r = board.size()-1; r > -1; --r){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }

    return find_maximum(board, depth);
}

int move_right(vector<vector<vector<int>>>&board, int depth){
    for(int r = 0; r < board.size(); ++r){
        for(int c = board.size()-1; c > -1; --c)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int c = board.size()-1; c > -1; --c){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }
    
    return find_maximum(board, depth);
}

int move_left(vector<vector<vector<int>>>&board, int depth){
    for(int r = 0; r < board.size(); ++r){
        for(int c = 0; c < board.size(); ++c)
            if(board[r][c][depth-1])
                que.push(board[r][c][depth-1]);

        for(int c = 0; c < board.size(); ++c){
            if(que.size() > 1){
                board[r][c][depth] = que.front();
                que.pop();
                if(que.front() == board[r][c][depth]){
                    board[r][c][depth] += que.front();
                    que.pop();
                }
            }
            else if(que.size() == 1){
                board[r][c][depth] = que.front();
                que.pop();
            }
            else
                board[r][c][depth] = 0;
        }
    }
    
    return find_maximum(board, depth);
}

int find_maximum(vector<vector<vector<int>>>&board, int depth){
    int res = 0;
    if(depth == 5){
        for(int r = 0; r < board.size(); ++r)
            for(int c = 0; c < board.size(); ++c)
                res = max(res, board[r][c][5]);

        return res;
    }

    res = max(res, move_up(board, depth+1));
    res = max(res, move_down(board, depth+1));
    res = max(res, move_right(board, depth+1));
    res = max(res, move_left(board, depth+1));

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    
    vector<vector<vector<int>>> board(n, vector<vector<int>>(n, vector<int>(6)));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            cin >> board[r][c][0];
    
    cout << find_maximum(board, 0) << "\n";
    return 0;
}
