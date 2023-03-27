# (7576) 토마토
## :100: Algorithm
## 문제
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 

![Baekjoon7576_img1](https://upload.acmicpc.net/de29c64f-dee7-4fe0-afa9-afd6fc4aad3a/-/preview/)

창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

## 입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

## 출력
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

## 풀이
해당 문제는 BFS를 이용하여 해결하였습니다.  

1. 초기설정으로 현제 위치의 토마토가 익은 위치의 토마토라면 큐에 넣습니다.  
2. 큐에서 하나씩 빼면서 해당 토마토가 익게 할 수 있는 토마토라면 해당 토마토의 값을 현제 뺀 토마토의 값+1을 한 후 큐에 넣습니다.
3. 위의 과정이 끝나면 모든 값을 보며 가장 큰 값을 출력합니다. 이때 0의 값이 있으면 -1을 출력 합니다.

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int count_day(int n, int m, vector<vector<int>>&board){
    int res = 0;

    pair<int,int> curr;
    queue<pair<int,int>> que;
    // reset que
    for(int r = 0; r < m; ++r)
        for(int c = 0; c < n; ++c)
            if(board[r][c] == 1)
                que.push({r, c});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        // up
        if(curr.first > 0 && !board[curr.first-1][curr.second]){
            board[curr.first-1][curr.second] = board[curr.first][curr.second]+1;
            que.push({curr.first-1, curr.second});
        }
        // down
        if(curr.first < m-1 && !board[curr.first + 1][curr.second]){
            board[curr.first+1][curr.second] = board[curr.first][curr.second]+1;
            que.push({curr.first+1, curr.second});
        }
        // left
        if(curr.second > 0 && !board[curr.first][curr.second-1]){
            board[curr.first][curr.second-1] = board[curr.first][curr.second]+1;
            que.push({curr.first, curr.second-1});
        }
        // right
        if(curr.second < n-1 && !board[curr.first][curr.second+1]){
            board[curr.first][curr.second+1] = board[curr.first][curr.second]+1;
            que.push({curr.first, curr.second+1});
        }
    }

    for(int r = 0; r < m; ++r)
        for(int c = 0; c < n; ++c){
            if(board[r][c] == 0)
                return -1;
            if(res < board[r][c])
                res = board[r][c];
        }

    return res-1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, cnt = 0;
    cin >> n >> m;

    vector<vector<int>> board(m, vector<int>(n));
    for(int r = 0; r < m; ++r)
        for(int c = 0 ; c < n; ++c)
            cin >> board[r][c];

    cout << count_day(n, m, board) << "\n";    
    return 0;
}

```