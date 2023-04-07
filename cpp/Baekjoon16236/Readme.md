# (16236) 아기 상어
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/16236)
#
## 문제
N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.

아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.

- 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
- 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
- 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
    - 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
    - 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.


아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.

둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

- 0: 빈 칸
- 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
- 9: 아기 상어의 위치

아기 상어는 공간에 한 마리 있다.
#
## 출력
첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
#
## 풀이
해당 문제는 BFS를 이용하는 문제입니다.  

우선 아기상어의 위치를 알고 있어야 합니다.   
저는 별도의 구조체인 Shark를 선언해 주었고 해당 구조체는 위치의 x,y값 크기인 size, 먹은 갯수인 eat를 모두 정수 형으로 가지고 있습니다.  

상어의 위치를 잡았다면 BFS를 이용하여 가장 가까운 먹이를 탐색합니다.  
이때 주의 해야할 점은 먹을 수 있는 먹이의 우선 순위가 있습니다.  
해당 부분을 주의해 탐색하여 먹이를 먹고 상어의 위치를 갱신시키고 먹은 곳은 0으로 바꾼후 해당 먹이의 깊이를 누적합산합니다.  

위의 BFS에서 먹은 것이 있다면 eat를 증가시키고 만약 eat와 size가 값이 같다면 size를 증가시키고 eat를 0으로 초기화 합니다.  

먹은 것이 없다면 더이상 먹을 수 있는 것이 없다는 뜻이므로 먹이의 깊이를 누적한 값을 반환해 줍니다.  

```cpp
#include <unordered_set>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Shark{
    int x,y,size,eat;
    Shark() : x(0), y(0), size(2), eat(0){}
};

struct Point{
    int x, y, d;
    Point(int X, int Y, int D) : x(X), y(Y), d(D){}
};


bool BFS(vector<vector<int>>&board, Shark&s, int&ans){
    vector<vector<bool>> visited(board.size(),vector<bool>(board.size()));
    Point p(0,0,0);
    queue<Point> que;
    que.push(Point(s.x,s.y,0));
    visited[s.x][s.y] = true;

    while(!que.empty()){
        p = que.front();
        que.pop();

        if(p.d && board[p.x][p.y] && board[p.x][p.y] < s.size){
            while(!que.empty() && que.front().d == p.d){
                Point cmp = que.front();
                que.pop();

                if(board[cmp.x][cmp.y]&&board[cmp.x][cmp.y] < s.size){
                    if(p.x > cmp.x)
                        p = cmp;
                    else if(p.x == cmp.x && p.y > cmp.y)
                        p = cmp;
                }
            }

            board[s.x][s.y] = 0;
            board[p.x][p.y] = 9;
            
            s.x = p.x;
            s.y = p.y;
 
            ans += p.d;
            return true;
        }
        //up
        if(p.x > 0 && !visited[p.x-1][p.y] && board[p.x-1][p.y] <= s.size){
            que.push(Point(p.x-1, p.y, p.d+1));
            visited[p.x-1][p.y] = true;
        }
        //left
        if(p.y > 0 && !visited[p.x][p.y-1] && board[p.x][p.y-1] <= s.size){
            que.push(Point(p.x, p.y-1, p.d+1));
            visited[p.x][p.y-1] = true;
        }
        //right
        if(p.y < board.size()-1 && !visited[p.x][p.y+1] && board[p.x][p.y+1] <= s.size){
            que.push(Point(p.x, p.y+1, p.d+1));
            visited[p.x][p.y+1] = true;
        }
        //down
        if(p.x < board.size()-1 && !visited[p.x+1][p.y] && board[p.x+1][p.y] <= s.size){
            que.push(Point(p.x+1, p.y, p.d+1));
            visited[p.x+1][p.y] = true;
        }
    }
    return false;
}

int babyShark(vector<vector<int>>&board){
    int ans = 0;
    Shark s;
    for(int r = 0; r < board.size(); ++r){
        for(int c = 0; c < board.size(); ++c)
            if(board[r][c] == 9){
                s.x = r;
                s.y = c;
                break;
            }

        if(board[s.x][s.y] == 9) break;
    }

    while(BFS(board, s, ans))
        if(++s.eat == s.size){
            s.eat = 0;
            ++s.size;
        }
    
    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> board(n, vector<int>(n));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            cin >> board[r][c];

    cout << babyShark(board) << "\n";
    return 0;
}
```