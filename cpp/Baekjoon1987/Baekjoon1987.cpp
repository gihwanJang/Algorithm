#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

vector<bool> spelling(26);
vector<vector<int>> go = {
    {-1, 0},
    {1, 0},
    {0, -1},
    {0, 1}
};

bool isCanMove(vector<string>&board, vector<vector<bool>>&visited, int r, int c){
    if((r < 0 || r == board.size()) || (c < 0 || c == board[0].size()))
        return false;
    if(visited[r][c]) return false;
    if(spelling[board[r][c]-65]) return false;
    return true;
}

int travelAllPath(vector<string>&board, vector<vector<bool>>&visited, int r, int c, int curr){
    int res = curr;

    visited[r][c] = true;
    spelling[board[r][c] - 65] = true;

    for(int i = 0; i < 4; ++i)
        if(isCanMove(board, visited, r + go[i][0], c + go[i][1]))
            res = max(res, travelAllPath(board, visited, r + go[i][0], c + go[i][1], curr+1));

    visited[r][c] = false;
    spelling[board[r][c] - 65] = false;

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int r, c;
    cin >> r >> c;

    vector<string> board(r);
    vector<vector<bool>> visited(r, vector<bool>(c));
    for(int i = 0; i < r; ++i)
        cin >> board[i];

    cout << travelAllPath(board, visited, 0, 0, 1) << "\n";
    return 0;
}
