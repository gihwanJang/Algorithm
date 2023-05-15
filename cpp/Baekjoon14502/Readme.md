# (14502) 연구소
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/14502)
#
## 문제
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.  
연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.   
일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.  
예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

```
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
```

이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.  
2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

```
2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
```

바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

```
2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
```

벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.  
연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

#
## 입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.
#
## 출력
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.
#
## 풀이
해당 문제는 (backtracking)과 (BFS, DFS)를 이용하면 해결할 수 있는 문제입니다.  

우선 그래프를 입력 받습니다.  
이때 입력을 받으며 바이러스 즉 2의 좌표는 따로 list에 모아줍니다.  

이후 모든 경우의 수의 벽을 백트래킹을 이용하여 3개를 세웁니다.  
만약 벽을 3개 세웠다면 이전에 저장해둔 바이러스의 좌표를 각각 DFS 또는 BFS방식으로 순회하며 0을 2로 변환후 0을 갯수를 세어줍니다.  
이후 해당 0의 갯수를 이전 값과 비교하여 최댓 값으로 유지합니다.  

위의 과정이 모두 끝나면 0의 최대 갯수를 출력해 줍니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int maxSaftyArea(vector<vector<int>> board, vector<pair<int,int>>&virus){
    int maxSize = 0;
    pair<int,int> p;
    queue<pair<int,int>> que;
    
    for(int i = 0; i < virus.size(); ++i)
        que.push(virus[i]);

    while(!que.empty()){
        p = que.front();
        que.pop();

        if(p.first+1 < board.size() && !board[p.first+1][p.second]){
            board[p.first+1][p.second] = 2;
            que.push({p.first+1, p.second});
        }
        if(p.first > 0 && !board[p.first-1][p.second]){
            board[p.first-1][p.second] = 2;
            que.push({p.first-1, p.second});
        }
        if(p.second+1 < board[0].size() && !board[p.first][p.second+1]){
            board[p.first][p.second+1] = 2;
            que.push({p.first, p.second+1});
        }
        if(p.second > 0 && !board[p.first][p.second-1]){
            board[p.first][p.second-1] = 2;
            que.push({p.first, p.second-1});
        }
    }

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board[0].size(); ++c)
            if(!board[r][c])
                ++maxSize;

    return maxSize;
}

int saftyArea(vector<vector<int>>&board, vector<pair<int,int>>&virus, int r_c, int depth){
    if(depth == 3)
        return maxSaftyArea(board, virus);

    int res = 0;

    for(int r = r_c; r < board.size(); ++r)
        for(int c = 0; c < board[0].size(); ++c)
            if(!board[r][c]){
                board[r][c] = 1;
                res = max(res, saftyArea(board, virus, r, depth+1));
                board[r][c] = 0;
            }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<pair<int,int>> virus;
    vector<vector<int>> board(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c){
            cin >> board[r][c];

            if(board[r][c] == 2)
                virus.push_back({r, c});
        }

    cout << saftyArea(board, virus, 0, 0) << "\n";
    return 0;
}
``` 