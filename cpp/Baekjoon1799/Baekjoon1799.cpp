#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void placeBishops(vector<vector<int>>&board, vector<bool>&visited1, vector<bool>&visited2, pair<int,int>&black_white, int n, int r, int c, int cnt, bool color)
{
    if(c >= n)
    {
        ++r;
        c = (c % 2 == 0);
    }

    if(r >= n)
    {
        if(color)
            black_white.first = max(cnt, black_white.first);
        else
            black_white.second = max(cnt, black_white.second);
        return;
    }

    if(board[r][c] && !visited1[r + c] && !visited2[r - c + n])
    {
        visited1[r + c] = true;
        visited2[r - c + n] = true;

        placeBishops(board, visited1, visited2, black_white, n, r, c+2, cnt + 1, color);

        visited1[r + c] = false;
        visited2[r - c + n] = false;
    }

    placeBishops(board, visited1, visited2, black_white, n, r, c+2, cnt, color);
}

int getMaximumNumberOfBishop(vector<vector<int>>&board, int n)
{
    pair<int,int> black_white;
    vector<bool> visited1(n*2);
    vector<bool> visited2(n*2);

    placeBishops(board, visited1, visited2, black_white, n, 0, 0, 0, true);
    placeBishops(board, visited1, visited2, black_white, n, 0, 1, 0, false);

    return black_white.first + black_white.second;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> board(n, vector<int>(n));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            cin >> board[r][c];

    cout << getMaximumNumberOfBishop(board, n) << "\n";
    return 0;
}
