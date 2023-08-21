# (16946) 벽 부수고 이동하기 4
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/16946)
#
## 문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 한 칸에서 다른 칸으로 이동하려면, 두 칸이 인접해야 한다. 두 칸이 변을 공유할 때, 인접하다고 한다.

각각의 벽에 대해서 다음을 구해보려고 한다.

- 벽을 부수고 이동할 수 있는 곳으로 변경한다.
- 그 위치에서 이동할 수 있는 칸의 개수를 세어본다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
#
## 입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다.
#
## 출력
맵의 형태로 정답을 출력한다. 원래 빈 칸인 곳은 0을 출력하고, 벽인 곳은 이동할 수 있는 칸의 개수를 10으로 나눈 나머지를 출력한다.
#
## 풀이
해당 문제는 DFS, BFS를 이용하면 해결 할 수 있는 문제입니다.

해당 문제는 1을 기준으로 해결하게 되면 0을 여러번 순회하게 되므로 시간 초과가 발생합니다.  
그러므로 0을 기준으로 구역을 나누어 먼저 카운트해 주어야합니다.  

우서 행렬을 입력 받은 후 0인 부분에 대하여 DFS실행합니다.  
이때 인접한 0에 대하여 같은 구역으로 지정하며 갯수를 따로 저장해 줍니다.

0인 부분의 구역 분할이 끝났다면 1인 부분에 인접한 구역의 값들을 더해 줍니다.

이후 행렬을 출력해 주시면 됩니다.

```cpp
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
```