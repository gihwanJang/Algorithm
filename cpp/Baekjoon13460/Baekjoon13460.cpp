#include <algorithm>
#include <iostream>
#include <vector>

#define INF 987654321

using namespace std;

pair<int, int> red;
pair<int, int> blue;

vector<vector<int>> dir = {
    {-1,0},
    {1,0},
    {0,-1},
    {0,1}
};

int game(vector<string>&board, int depth);
int up(vector<string>&board, int depth);
int down(vector<string>&board, int depth);
int left(vector<string>&board, int depth);
int right(vector<string>&board, int depth);
void restore(vector<string>&board, pair<int, int>&prev, pair<int, int>&curr);
bool withRB(vector<string>&board, int r, int c, int d);
bool move(vector<string>&board, int depth, pair<int,int>&prev_f, pair<int,int>&prev_s, pair<int,int>&curr_f, pair<int,int>&curr_s, int d, int rd, int&res);

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans;
    cin >> n >> m;

    vector<string> board(n);
    for(int r = 0; r < n; ++r){
        cin >> board[r];

        for(int c = 0; c < m; ++c){
            if(board[r][c] == 'R')
                red = make_pair(r, c);

            if(board[r][c] == 'B')
                blue = make_pair(r, c);
        }
    }

    ans = game(board, 0);
    cout << (ans == INF ? -1 : ans) << "\n";
    return 0;
}

int game(vector<string>&board, int depth){
    if(depth == 10) return INF;

    int res = INF;

    res = min(res, up(board, depth+1));
    res = min(res, down(board, depth+1));
    res = min(res, left(board, depth+1));
    res = min(res, right(board, depth+1));
    
    return res;
}

int up(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&up = red.first < blue.first ? red : blue;
    pair<int,int>&down = red.first < blue.first ? blue : red;
    pair<int,int> prev_up = make_pair(up.first, up.second);
    pair<int,int> prev_down = make_pair(down.first, down.second);

    if(move(board, depth, prev_up, prev_down, up, down, 0, 1, m_res))
        return m_res;
    if(move(board, depth, prev_down, prev_up, down, up, 0, 1, m_res))
        return m_res;

    res = min(res,game(board, depth));

    restore(board, prev_down, down);
    restore(board, prev_up, up);

    return res;
}

int down(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&up = red.first < blue.first ? red : blue;
    pair<int,int>&down = red.first < blue.first ? blue : red;
    pair<int,int> prev_up = make_pair(up.first, up.second);
    pair<int,int> prev_down = make_pair(down.first, down.second);

    if(move(board, depth, prev_down, prev_up, down, up, 1, 0, m_res))
        return m_res;
    if(move(board, depth, prev_up, prev_down, up, down, 1, 0, m_res))
        return m_res;

    res = min(res,game(board, depth));

    restore(board, prev_up, up);
    restore(board, prev_down, down);

    return res;
}

int left(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&left = red.second < blue.second ? red : blue;
    pair<int,int>&right = red.second < blue.second ? blue : red;
    pair<int,int> prev_left = make_pair(left.first, left.second);
    pair<int,int> prev_right = make_pair(right.first, right.second);

    if(move(board, depth, prev_left, prev_right, left, right, 2, 3, m_res))
        return m_res;
    if(move(board, depth, prev_right, prev_left, right, left, 2, 3, m_res))
        return m_res;
    
    res = min(res,game(board, depth));

    restore(board, prev_right, right);
    restore(board, prev_left, left);

    return res;
}

int right(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&left = red.second < blue.second ? red : blue;
    pair<int,int>&right = red.second < blue.second ? blue : red;
    pair<int,int> prev_left = make_pair(left.first, left.second);
    pair<int,int> prev_right = make_pair(right.first, right.second);

    if(move(board, depth, prev_right, prev_left, right, left, 3, 2, m_res))
        return m_res;
    if(move(board, depth, prev_left, prev_right, left, right, 3, 2, m_res))
        return  m_res;

    res = min(res,game(board, depth));

    restore(board, prev_left, left);
    restore(board, prev_right, right);

    return res;
}

bool move(vector<string>&board, int depth, pair<int,int>&prev_f, pair<int,int>&prev_s, pair<int,int>&curr_f, pair<int,int>&curr_s, int d, int rd, int&res){
    while(board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] == '.' || board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] == 'O'){
        if(board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] == 'O'){
            restore(board, prev_s, curr_s);
            restore(board, prev_f, curr_f);
            res=board[curr_f.first][curr_f.second] == 'R' && !withRB(board,curr_f.first,curr_f.second, rd) ? depth : INF;
            return true;
        }

        board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] = board[curr_f.first][curr_f.second];
        board[curr_f.first][curr_f.second] = '.';

        curr_f.first += dir[d][0];
        curr_f.second += dir[d][1];
    }

    return false;
}

bool withRB(vector<string>&board, int r, int c, int d){
    for(; board[r][c] != '#'; r+=dir[d][0], c+=dir[d][1])
        if(board[r][c] == 'B')
            return true;

    return false;
}

void restore(vector<string>&board, pair<int, int>&prev, pair<int, int>&curr){
    if(prev.first != curr.first || prev.second != curr.second){
        board[prev.first][prev.second] = board[curr.first][curr.second];
        board[curr.first][curr.second] = '.';
        curr.first = prev.first;
        curr.second = prev.second;
    }
}