#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

#define INF 1234567891

using namespace std;

void reverse(vector<vector<bool>>&a, int row, int col)
{
    for(int r = row; r < row+3; ++r)
        for(int c = col; c < col+3; ++c)
            a[r][c] = !a[r][c];
}

bool checkEqual(vector<vector<bool>>&a, vector<vector<bool>>&b)
{
    for(int r = 0; r < a.size(); ++r)
        for(int c = 0; c < a[0].size(); ++c)
            if(a[r][c] != b[r][c])
                return false;

    return true;
}

int changeMatrix(vector<vector<bool>>&a, vector<vector<bool>>&b)
{
    int ans = 0;

    for(int r = 0; r+2 < a.size(); ++r)
        for(int c = 0; c+2 < a[0].size(); ++c)
            if(a[r][c] != b[r][c]){
                ++ans;
                reverse(a, r, c);
            }

    if(!checkEqual(a, b))
        ans = -1;

    return ans;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    string s;
    vector<vector<bool>> a(n, vector<bool>(m));
    vector<vector<bool>> b(n, vector<bool>(m));

    for(int r = 0; r < n; ++r)
    {
        cin >> s;

        for(int c = 0; c < m; ++c)
            a[r][c] = (s[c] == '1');
    }
    for(int r = 0; r < n; ++r)
    {
        cin >> s;

        for(int c = 0; c < m; ++c)
            b[r][c] = (s[c] == '1');
    }

    cout << changeMatrix(a, b) << "\n";
    return 0;
}
