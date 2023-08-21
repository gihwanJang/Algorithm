#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int zoning(vector<vector<int>>&mat, int r, int c, int n, int m, int idx)
{
    int cnt = 1;
    mat[r][c] = idx;

    if(r > 0 && !mat[r-1][c])
        cnt += zoning(mat, r-1, c, n, m, idx);
    if(r+1 < n && !mat[r+1][c])
        cnt += zoning(mat, r+1, c, n, m, idx);
    if(c > 0 && !mat[r][c-1])
        cnt += zoning(mat, r, c-1, n, m, idx);
    if(c+1 < m && !mat[r][c+1])
        cnt += zoning(mat, r, c+1, n, m, idx);

    return cnt;
}

void convertMat(vector<vector<int>>&mat, vector<int>&section, vector<vector<int>>&converted, int r, int c, int n, int m)
{
    converted[r][c] = 1;
    vector<bool> visited(section.size());

    if(r > 0 && mat[r-1][c] > 0 && !visited[mat[r-1][c]])
    {
        converted[r][c] += section[mat[r-1][c]];
        visited[mat[r-1][c]] = true;
    }
    if(r+1 < n && mat[r+1][c] > 0 && !visited[mat[r+1][c]])
    {
        converted[r][c] += section[mat[r+1][c]];
        visited[mat[r+1][c]] = true;
    }
    if(c > 0 && mat[r][c-1] > 0 && !visited[mat[r][c-1]])
    {
        converted[r][c] += section[mat[r][c-1]];
        visited[mat[r][c-1]] = true;
    }
    if(c+1 < m && mat[r][c+1] > 0 && !visited[mat[r][c+1]])
    {
        converted[r][c] += section[mat[r][c+1]];
        visited[mat[r][c+1]] = true;
    }

    converted[r][c] %= 10;
}

void makeRoutes(vector<vector<int>>&mat, int n, int m)
{
    int section_idx = 1;
    vector<int> section = {0};
    vector<vector<int>> converted(n, vector<int>(m));

    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            if(!mat[r][c])
                section.push_back(zoning(mat, r, c, n, m, section_idx++));
    
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            if(mat[r][c] == -1)
                convertMat(mat, section, converted, r, c, n, m);

    mat = converted;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> mat(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
    {
        string in;
        cin >> in;

        for(int c = 0; c < in.size(); ++c)
            mat[r][c] = (in[c] == '0' ? 0 : -1);
    }

    makeRoutes(mat, n, m);

    for(int r = 0; r < n; ++r)
    {
        for(int c = 0; c < m; ++c)
            cout << mat[r][c];
        cout << "\n";
    }
    return 0;
}
