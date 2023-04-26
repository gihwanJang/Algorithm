# (2206) 벽 부수고 이동하기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2206)
#
## 문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.
#
## 출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.
#
## 풀이
해당 문제는 최단거리를 찾는 문제로 BFS를 이용하면 해결이 가능한 문제입니다.  

우선 해당 문제의 입력을 받고 BFS를 진행합니다.  

BFS를 하기위해 해당 위치의 정보를 나타내는 Location 구조체를 만들어 줍니다.  
해당 구조체는 위치정보인 x,y와 현제 위치 까지의 거리인 depth, 벽을 부술 수 있는지에 대한 여부인 can 값을 가집니다.  

해당 구조체를 이용하여 BFS를 진행하는데 이때 주의 해야할 점은 벽을 부술 수 있다는 조건이 존재하므로 BFS를 진행 했을때 아래의 1가지 조건을 더 고려해 주어야합니다.  

- 부술 수 있는데 이미 방문한 곳이라 해당 칸을 방문하지 못하는 경우  

해당 조건을 해결 하기 위해서는 visited 배열을 부술 수 있는 경우와 못 부수는 경우 2개를 두고 진행하여야 합니다.  

BFS의 진행은 아래와 같습니다.  

- 큐에서 현재의 위치를 가지고 왔을 때 부술 수 있는 경우  
    1. 상하좌우에 대하여 이동가능한지 확인을 하고 visited_true에 대하여 이미 방문한 것인지 확인한다.  
    2. 위의 조건이 충족한다면 큐에 해당 칸의 정보를 넣어주는데 이때 can의 값은 이동한 칸이 0이면 true 아니면 false의 값을 가진다.  
    3. can이 true이면 visited_true를 true로 바꿔주고 false면 visited_false를 true로 바꿔준다.  
- 큐에서 현재의 위치를 가지고 왔을 때 부술 수 없는 경우
    1. 상하좌우에 대하여 이동가능한지 확인을 하고 visited_false에 대하여 이미 방문한 것인지 확인하고 이동할 칸이 벽인지 여부를 확인한다.  
    2. 위의 조건이 충족한다면 큐에 해당 칸의 정보를 넣어주는데 이때 can의 값은 false의 값을 가진다.
    3. visited는 이동할 칸의 visited_false를 true로 바꿔준다.  

위의 과정을 반복하며 현제의 칸이 목적지이면 depth를 출력해주고 만약 반복이 끝날 때 까지 도달하지 못하면 -1을 출력해 줍니다.  

```cpp
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Location{
    int x, y, depth;
    bool can;

    Location(int X, int Y, int D, bool C): x(X), y(Y), depth(D), can(C){}
};

int BFS(string*board, int n, int m){
    vector<vector<bool>> visited_false(n, vector<bool>(m));
    vector<vector<bool>> visited_true(n, vector<bool>(m));
    Location curr(0,0,1,true);
    queue<Location> que;

    que.push(curr);
    visited_true[0][0] = true;

    while(!que.empty()){
        curr = que.front();
        que.pop();

        if(curr.x == n-1 && curr.y == m-1)
            return curr.depth;

        if(curr.can){
            if(curr.x > 0 && !visited_true[curr.x-1][curr.y]){
                que.push(Location(curr.x-1, curr.y, curr.depth+1, board[curr.x-1][curr.y] == '0'));

                if(board[curr.x-1][curr.y] == '0')
                    visited_true[curr.x-1][curr.y] = true;
                else
                    visited_false[curr.x-1][curr.y] = true;
            }
            if(curr.x < n-1 && !visited_true[curr.x+1][curr.y]){
                que.push(Location(curr.x+1, curr.y, curr.depth+1, board[curr.x+1][curr.y] == '0'));
                
                if(board[curr.x+1][curr.y] == '0')
                    visited_true[curr.x+1][curr.y] = true;
                else
                    visited_false[curr.x+1][curr.y] = true;
            }
            if(curr.y > 0 && !visited_true[curr.x][curr.y-1]){
                que.push(Location(curr.x, curr.y-1, curr.depth+1, board[curr.x][curr.y-1] == '0'));
                
                if(board[curr.x][curr.y-1] == '0')
                    visited_true[curr.x][curr.y-1] = true;
                else
                    visited_false[curr.x][curr.y-1] = true;
            }
            if(curr.y < m-1 && !visited_true[curr.x][curr.y+1]){
                que.push(Location(curr.x, curr.y+1, curr.depth+1, board[curr.x][curr.y+1] == '0'));
                
                if(board[curr.x][curr.y+1] == '0')
                    visited_true[curr.x][curr.y+1] = true;
                else
                    visited_false[curr.x][curr.y+1] = true;
            }
        }
        else{
            if(curr.x > 0 && !visited_false[curr.x-1][curr.y] && board[curr.x-1][curr.y] == '0'){
                que.push(Location(curr.x-1, curr.y, curr.depth+1, false));
                visited_false[curr.x-1][curr.y] = true;
            }
            if(curr.x < n-1 && !visited_false[curr.x+1][curr.y] && board[curr.x+1][curr.y] == '0'){
                que.push(Location(curr.x+1, curr.y, curr.depth+1, false));
                visited_false[curr.x+1][curr.y] = true;
            }
            if(curr.y > 0 && !visited_false[curr.x][curr.y-1] && board[curr.x][curr.y-1] == '0'){
                que.push(Location(curr.x, curr.y-1, curr.depth+1, false));
                visited_false[curr.x][curr.y-1] = true;
            }
            if(curr.y < m-1 && !visited_false[curr.x][curr.y+1] && board[curr.x][curr.y+1] == '0'){
                que.push(Location(curr.x, curr.y+1, curr.depth+1, false));
                visited_false[curr.x][curr.y+1] = true;
            }
        }
    }

    return -1;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    string*board = new string[n];

    for(int r = 0; r < n; ++r)
        cin >> board[r];

    cout << BFS(board, n, m) << "\n";
    return 0;
}

```