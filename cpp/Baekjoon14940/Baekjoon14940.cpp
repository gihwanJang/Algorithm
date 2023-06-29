#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Loc
{
    int r, c, d;

    Loc(int R, int C, int D):r(R), c(C), d(D){};
};

bool checkPath(int r, int c, int n, int m)
{
    if(0 <= r && r < n && 0 <= c && c < m)
        return true;
    return false;
}

void BFS(vector<vector<int>>&board, int n, int m)
{
    vector<vector<bool>> visited(n, vector<bool>(m, false));

    Loc curr(0,0,0);
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            if(board[r][c] == 2)
            {
                curr.r = r;
                curr.c = c;
            }

    queue<Loc> que;
    que.push(curr);

    while(!que.empty())
    {
        curr = que.front();
        que.pop();

        if(visited[curr.r][curr.c])
            continue;
        
        visited[curr.r][curr.c] = true;
        board[curr.r][curr.c] = curr.d;

        if(checkPath(curr.r-1, curr.c, n, m) && board[curr.r-1][curr.c])
            que.push(Loc(curr.r-1, curr.c, curr.d+1));
        if(checkPath(curr.r+1, curr.c, n, m) && board[curr.r+1][curr.c])
            que.push(Loc(curr.r+1, curr.c, curr.d+1));
        if(checkPath(curr.r, curr.c-1, n, m) && board[curr.r][curr.c-1])
            que.push(Loc(curr.r, curr.c-1, curr.d+1));
        if(checkPath(curr.r, curr.c+1, n, m) && board[curr.r][curr.c+1])
            que.push(Loc(curr.r, curr.c+1, curr.d+1));
    }

    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            if(visited[r][c] && board[r][c])
                board[r][c] = -1;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int r, c;
    cin >> r >> c;

    vector<vector<int>> board(r, vector<int>(c));
    for(int i = 0; i < r; ++i)
        for(int j = 0; j < c;++j)
            cin >> board[i][j];

    BFS(board, r, c);

    for(int i = 0; i < r; ++i)
    {
        for(int j = 0; j < c;++j)
            cout << board[i][j] << " ";
        cout << "\n";
    }
    return 0;
}
