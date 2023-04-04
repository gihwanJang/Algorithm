#include<iostream>
#include<vector>

using namespace std;

void BFS(vector<string>&board, vector<vector<bool>>&visited, int r, int c){
    visited[r][c] = true;

    if(r>0 && !visited[r-1][c] && (board[r][c] == board[r-1][c]))
        BFS(board, visited, r-1, c);

    if(r < board.size()-1 && !visited[r+1][c] && (board[r][c] == board[r+1][c]))
        BFS(board, visited, r+1, c);
        
    if(c>0 && !visited[r][c-1] && (board[r][c] == board[r][c-1]))
        BFS(board, visited, r, c-1);
        
    if(c < board.size()-1 && !visited[r][c+1] && (board[r][c] == board[r][c+1]))
        BFS(board, visited, r, c+1);
}

int section(vector<string>&board){
    int res = 0;
    vector<vector<bool>> visited(board.size(), vector<bool>(board.size()));

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board.size(); ++c)
            if(!visited[r][c]){
                BFS(board, visited, r, c);
                ++res;
            }

    return res;
}

void changeColor(vector<string>&board){
    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board.size(); ++c)
            if(board[r][c] == 'G')
                board[r][c] = 'R';
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<string> board(n);
    for(int i = 0; i < n; ++i)
        cin >> board[i];

    cout << section(board) << " ";

    changeColor(board);
    cout << section(board) << "\n";
    return 0;
}
