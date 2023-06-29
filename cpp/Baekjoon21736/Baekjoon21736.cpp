#include <iostream>
#include <vector>
#include <string>
#include <queue>

using namespace std;

struct  Loc
{
    int r, c;

    Loc(int R, int C):r(R), c(C){};
};

bool isPath(int r, int c, int n, int m)
{
    if(0 <= r && r < n && 0 <= c && c < m)
        return true;

    return false;
}

int getNumberOfPeopleMet(vector<string>&board, int n, int m)
{
    int res = 0;
    Loc loc(0,0);
    queue<Loc> que;
    vector<vector<bool>> visited(n, vector<bool>(m, false));

    for(int r = 0; r < n; ++r)
    {
        for(int c = 0; c < m; ++c)
            if(board[r][c] == 'I')
            {
                loc = Loc(r, c);
                break;
            }
        
        if(board[loc.r][loc.c] == 'I')
            break;
    }

    que.push(loc);
    while(!que.empty())
    {
        loc = que.front();
        que.pop();

        if(visited[loc.r][loc.c])
            continue;

        visited[loc.r][loc.c] = true;
        if(board[loc.r][loc.c] == 'P')
            ++res;

        if(isPath(loc.r-1, loc.c, n, m) && board[loc.r-1][loc.c] != 'X')
            que.push(Loc(loc.r-1, loc.c));
        if(isPath(loc.r+1, loc.c, n, m) && board[loc.r+1][loc.c] != 'X')
            que.push(Loc(loc.r+1, loc.c));
        if(isPath(loc.r, loc.c-1, n, m) && board[loc.r][loc.c-1] != 'X')
            que.push(Loc(loc.r, loc.c-1));
        if(isPath(loc.r, loc.c+1, n, m) && board[loc.r][loc.c+1] != 'X')
            que.push(Loc(loc.r, loc.c+1));
    }

    return res;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans;
    cin >> n >> m;

    vector<string> board(n);
    for(int r = 0; r < n; ++r)
        cin >> board[r];

    ans = getNumberOfPeopleMet(board, n, m);

    if(ans)
        cout << ans << "\n";
    else
        cout << "TT\n"; 
    return 0;
}
