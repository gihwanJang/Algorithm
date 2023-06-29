# (14940) 쉬운 최단거리
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/14940)
#
## 문제
지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.

문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.
#
## 입력
지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)

다음 n개의 줄에 m개의 숫자가 주어진다. 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.
## 출력
각 지점에서 목표지점까지의 거리를 출력한다. 원래 갈 수 없는 땅인 위치는 0을 출력하고, 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
#
## 풀이
해당 문제는 BFS를 이용하면 해결 할 수 있는 문제입니다.

먼저 값이 2인 위치를 찾습니다.  
해당 위치의 값과 거리의 값을 가진 자료구조를 생성후 큐에 넣어줍니다.  
그리고 아래의 과정을 큐가 값이 없을 때 까지 반복합니다.

먼저 큐의 값을 빼고 해당 값의 위치에 방문한적이 있는지 체크합니다.
만약 방문한적이 없다면 해당 표에 해당 거리 값을 반영해 주고 방문한 위치로 체크한후 상하좌우로 진행할 수 있는 방향인지 체크합니다.
만약 진행할 수 있는 방향이라면 해당 방향의 위치의 값과 현제 거리의 +1한 값을 큐에 넣어 줍니다.

마지막으로 방문한적 없는 곳이 진행 할 수 있는 방향이라면 해당 값을 -1로 바꿔줍니다.

거리표를 출력해 줍니다.

```cpp
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
```