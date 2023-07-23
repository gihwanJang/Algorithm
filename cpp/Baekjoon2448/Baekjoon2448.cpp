#include <iostream>
#include <vector>

using namespace std;

void drawStar(vector<vector<char>>&mat, int r, int c, int n)
{
    if(n == 3)
    {
        mat[r][c] = '*';
        mat[r+1][c-1] = '*';
        mat[r+1][c+1] = '*';

        for(int col = c-2; col <= c+2; ++col)
            mat[r+2][col] = '*';

        return;
    }

    drawStar(mat, r, c, n/2);
    drawStar(mat, r + n/2, c - n/2, n/2);
    drawStar(mat, r + n/2, c + n/2, n/2);
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<char>> mat(n, vector<char>(2*n - 1));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < 2*n - 1; ++c)
            mat[r][c] = ' ';

    drawStar(mat, 0, n-1, n);

    for(int r = 0; r < n; ++r)
    {
        for(int c = 0; c < 2*n - 1; ++c)
        {
            cout << mat[r][c];
        }
        cout << "\n";
    }
    return 0;
}
