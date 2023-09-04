# (1890) 점프
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1890)
#
## 문제
N×N 게임판에 수가 적혀져 있다. 이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.

각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다. 반드시 오른쪽이나 아래쪽으로만 이동해야 한다. 0은 더 이상 진행을 막는 종착점이며, 항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다. 한 번 점프를 할 때, 방향을 바꾸면 안 된다. 즉, 한 칸에서 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다.

가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 게임 판의 크기 N (4 ≤ N ≤ 100)이 주어진다. 그 다음 N개 줄에는 각 칸에 적혀져 있는 수가 N개씩 주어진다. 칸에 적혀있는 수는 0보다 크거나 같고, 9보다 작거나 같은 정수이며, 가장 오른쪽 아래 칸에는 항상 0이 주어진다.
#
## 출력
가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력한다. 경로의 개수는 263-1보다 작거나 같다.
#
## 풀이
해당 문제는 다이나믹 프로그래밍을 이용하면 해결 할 수 있는 문제입니다.  

우선 보드의 크기(n)과 nxn보드의 정보를 입력 받습니다.  

이후 보드 크기와 같은 dp 테이블을 만들어 줍니다.  
해당 dp테이블의 (0,0)좌표는 1 나머지는 0 으로 초기화해 줍니다.  

보드를 선형 순회하며 해당 보드의 값과 현제 좌표의 r, c를 각각 더하여 n 보다 작다면 해당 값을 더한 좌표 즉 (r + board[r][c], c), (r, c + board[r][c])의 dp테이블에 값을 더해줍니다.  
식으로 표현하면 아래와 같습니다.  
if(r + board[r][c] < n)->dp[r + board[r][c]][c] += dp[r][c]  
if(c + board[r][c] < n)->dp[r][c + board[r][c]] += dp[r][c] 

이때 주의 해야할 점은 (n-1, n-1)좌표를 중복하여 더하는 경우를 제외해 주어야하며 답의 범위가 2^63-1이므로 dp의 자료형을 long으로 해주셔야 합니다.

이후 dp테이블의 가장 마지막 값을 출력해줍니다.  

```cpp
#include <iostream>
#include <vector>

using namespace std;

long getRoute(vector<vector<int>>&board, int n)
{
    vector<vector<long>> dp(n, vector<long>(n));

    dp[0][0] = 1;
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
        {
            if(r + board[r][c] < n && (r != n-1 || c != n-1))
                dp[r + board[r][c]][c] += dp[r][c];
            if(c + board[r][c] < n && (r != n-1 || c != n-1))
                dp[r][c + board[r][c]] += dp[r][c];
        }

    return dp[n-1][n-1];
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

    cout << getRoute(board, n) << "\n";
    return 0;
}
```