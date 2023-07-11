#include <iostream>
#include <vector>

using namespace std;

struct Loc{
    int r, c;

    Loc(int row, int col):r(row), c(col){}
};

void spreadFineDust(vector<vector<int>>&board, Loc&cleaner)
{
    int r = board.size();
    int c = board[0].size();
    int count;

    vector<vector<int>> sub_board(board.size(), vector<int>(board[0].size()));

    for(int l_r = 0; l_r < r; ++l_r)
        for(int l_c = 0; l_c < c; ++l_c)
            if(board[l_r][l_c] > 0)
            {
                count = 0;
                // up
                if(0 <= l_r - 1 && !(l_r - 1 == cleaner.r && l_c == cleaner.c))
                {
                    sub_board[l_r-1][l_c] += board[l_r][l_c] / 5;
                    ++count;
                }
                // down
                if(l_r + 1 < r && !(l_r + 1 == cleaner.r - 1 && l_c == cleaner.c))
                {
                    sub_board[l_r+1][l_c] += board[l_r][l_c] / 5;
                    ++count;
                }
                // left
                if(0 <= l_c - 1 && !(l_c - 1 == cleaner.c && (l_r == cleaner.r || l_r == cleaner.r - 1)))
                {
                    sub_board[l_r][l_c-1] += board[l_r][l_c] / 5;
                    ++count;
                }
                // right
                if(l_c + 1 < c)
                {
                    sub_board[l_r][l_c+1] += board[l_r][l_c] / 5;
                    ++count;
                }

                board[l_r][l_c] -= (board[l_r][l_c] / 5) * count;
            }

    for(int l_r = 0; l_r < r; ++l_r)
        for(int l_c = 0; l_c < c; ++l_c)
            board[l_r][l_c] += sub_board[l_r][l_c];
}

void operateAirPurifier(vector<vector<int>>&board, Loc&cleaner)
{
    int r, c;

    for(r = cleaner.r-2, c = cleaner.c; 0 <= r-1; --r)
        board[r][c] = board[r-1][c];

    for(r = 0, c = cleaner.c; c+1 < board[0].size(); ++c)
        board[r][c] = board[r][c+1];

    for(r = 0, c = board[0].size()-1; r+1 < cleaner.r; ++r)
        board[r][c] = board[r+1][c];

    for(r = cleaner.r-1, c = board[0].size()-1; c-1 > 0; --c)
        board[r][c] = board[r][c-1];

    board[cleaner.r-1][1] = 0;

    for(r = cleaner.r+1, c = cleaner.c; r+1 < board.size(); ++r)
        board[r][c] = board[r+1][c];

    for(r = board.size()-1, c = cleaner.c; c+1 < board[0].size(); ++c)
        board[r][c] = board[r][c+1];

    for(r = board.size()-1, c = board[0].size()-1; r-1 >= cleaner.r; --r)
        board[r][c] = board[r-1][c];

    for(r = cleaner.r, c = board[0].size()-1; c-1 > 0; --c)
        board[r][c] = board[r][c-1];

    board[cleaner.r][1] = 0;
}

int getFineDustAmount(vector<vector<int>>&board, Loc&cleaner, int t)
{
    int mount = 0;

    while(t--)
    {
        spreadFineDust(board, cleaner);
        operateAirPurifier(board, cleaner);
    }

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board[0].size(); ++c)
            if(board[r][c] > 0)
                mount += board[r][c];

    return mount;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int r, c, t;
    cin >> r >> c >> t;

    Loc cleaner(0, 0);
    vector<vector<int>> board(r, vector<int>(c));
    for(int r_idx = 0; r_idx < r; ++r_idx)
        for(int c_idx = 0; c_idx < c; ++c_idx)
        {
            cin >> board[r_idx][c_idx];

            if(board[r_idx][c_idx] == -1)
                cleaner = Loc(r_idx, c_idx);
        }

    cout << getFineDustAmount(board, cleaner, t) << "\n";
    return 0;
}
