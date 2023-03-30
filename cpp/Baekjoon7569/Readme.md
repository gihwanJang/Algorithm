# (7569) 토마토
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/7569)

## 문제
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.

![boj7569](https://upload.acmicpc.net/c3f3343d-c291-40a9-9fe3-59f792a8cae9/-/preview/)

창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

## 입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H번 반복하여 주어진다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

## 출력
여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

## 풀이
해당 문제는 BFS를 이용하여 해결하였습니다.  

1. 초기설정으로 현제 위치의 토마토가 익은 위치의 토마토라면 큐에 넣습니다.  
2. 큐에서 하나씩 빼면서 해당 토마토가 익게 할 수 있는 토마토라면 해당 토마토의 값을 현제 뺀 토마토의 값+1을 한 후 큐에 넣습니다.
3. 위의 과정이 끝나면 모든 값을 보며 가장 큰 값을 출력합니다. 이때 0의 값이 있으면 -1을 출력 합니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct point_3d{
    int z, x, y;
};


int count_day(vector<vector<vector<int>>>&matrix){
    int res = 0;
    point_3d p;
    queue<point_3d> que;

    for(int z = 0; z < matrix.size(); ++z)
        for(int x = 0; x < matrix[z].size(); ++x)
            for(int y = 0; y < matrix[z][x].size(); ++y)
                if(matrix[z][x][y] == 1)
                    que.push({z, x, y});

    while(!que.empty()){
        p = que.front();
        que.pop();

        // 상
        if(p.y < matrix[0][0].size()-1 && !matrix[p.z][p.x][p.y+1]){
            matrix[p.z][p.x][p.y+1] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x, p.y+1});
        }
        // 하
        if(p.y > 0 && !matrix[p.z][p.x][p.y-1]){
            matrix[p.z][p.x][p.y-1] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x, p.y-1});
        }
        // 좌
        if(p.x > 0 && !matrix[p.z][p.x-1][p.y]){
            matrix[p.z][p.x-1][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x-1, p.y});
        }
        // 우
        if(p.x < matrix[0].size()-1 && !matrix[p.z][p.x+1][p.y]){
            matrix[p.z][p.x+1][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x+1, p.y});
        }
        // 위
        if(p.z < matrix.size()-1 && !matrix[p.z+1][p.x][p.y]){
            matrix[p.z+1][p.x][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z+1, p.x, p.y});
        }
        // 아래
        if(p.z > 0 && !matrix[p.z-1][p.x][p.y]){
            matrix[p.z-1][p.x][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z-1, p.x, p.y});
        }
    }

    for(int z = 0; z < matrix.size(); ++z)
        for(int x = 0; x < matrix[z].size(); ++x)
            for(int y = 0; y < matrix[z][x].size(); ++y){
                if(matrix[z][x][y] == 0)
                    return -1;
                
                res = max(res, matrix[z][x][y]);
            }
    
    return res-1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, n, h;
    cin >> m >> n >> h;

    vector<vector<vector<int>>> matrix(h, 
        vector<vector<int>>(n, 
            vector<int>(m)
    ));
    for(int z = 0; z < h; ++z)
        for(int x = 0; x < n; ++x)
            for(int y = 0; y < m; ++y)
                cin >> matrix[z][x][y];
    
    cout << count_day(matrix) << "\n";
    return 0;
}
```