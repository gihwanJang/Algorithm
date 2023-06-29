# (21736) 헌내기는 친구가 필요해
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/21736)
#
## 문제
2020년에 입학한 헌내기 도연이가 있다. 도연이는 비대면 수업 때문에 학교에 가지 못해 학교에 아는 친구가 없었다. 드디어 대면 수업을 하게 된 도연이는 어서 캠퍼스 내의 사람들과 친해지고 싶다. 

도연이가 다니는 대학의 캠퍼스는 $N \times M$ 크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다. 예를 들어, 도연이가 ($x$, $y$)에 있다면 이동할 수 있는 곳은 ($x+1$, $y$), ($x$, $y+1$), ($x-1$, $y$), ($x$, $y-1$)이다. 단, 캠퍼스의 밖으로 이동할 수는 없다.

불쌍한 도연이를 위하여 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.
#
## 입력
첫째 줄에는 캠퍼스의 크기를 나타내는 두 정수 $N$ ($ 1 \leq N \leq 600$), $M$ ($ 1 \leq M \leq 600$)이 주어진다.

둘째 줄부터 $N$개의 줄에는 캠퍼스의 정보들이 주어진다. O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.
#
## 출력
첫째 줄에 도연이가 만날 수 있는 사람의 수를 출력한다. 단, 아무도 만나지 못한 경우 TT를 출력한다.
#
## 풀이
해당 문제의 경우 BFS, DFS를 통하여 문제를 해결 할 수 있습니다.  

보드에 대하여 BFS, DFS를 진행하며 P를 만나면 카운트를 증가시킨 후 해당 카운트를 출력해 줍니다.

```cpp
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
```