# (10026) 적록색약
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/10026)
#
## 문제
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에
```
RRRBB  
GGBBB  
BBBRR  
BBRRR  
RRRRR  
```
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)

둘째 줄부터 N개 줄에는 그림이 주어진다.
#
## 출력
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
#
## 풀이
해당 문제는 bfs를 통해 해결 할 수 있는 문제입니다.   

bfs의 경우 queue를 이용하여 풀 수 있고 재귀를 이용하여 풀 수 있지만 해당 문제의 경우 메모리 제한이 걸려있어 재귀를 이용하여 해결 하여야 합니다.  

풀이는 아래와 같습니다.  

- 모든 칸을 방문하며 만약 방문하지 않은 칸이라면 BFS를 통해 해당 칸의 값을 탐색한다.  
    - BFS를 통하여 입력 칸의 값과 상하좌우의 칸의 값이 같으면 해당 칸을 재귀적으로 BFS를 통해 탐색하며 방문 칸으로 표기한다.

- 위의 절차가 끝나면 칸의 값이 G이면 R로 바꾼뒤 위의 과정을 다시 반복한다.  

```cpp
#include<iostream>
#include<vector>

using namespace std;

void BFS(vector<string>&board, vector<vector<bool>>&visited, int r, int c){
    visited[r][c] = true;

    if(r>0 && !visited[r-1][c] && (board[r][c] == board[r-1][c]))
        BFS(board, visited, r-1, c);

    if(r < board.size()-1 && !visited[r+1][c] && (board[r][c] == board[r+1][c]))
        BFS(board, visited, r+1, c);
        
    if(c>0 && !visited[r][c-1] && (board[r][c] == board[r][c-1]))
        BFS(board, visited, r, c-1);
        
    if(c < board.size()-1 && !visited[r][c+1] && (board[r][c] == board[r][c+1]))
        BFS(board, visited, r, c+1);
}

int section(vector<string>&board){
    int res = 0;
    vector<vector<bool>> visited(board.size(), vector<bool>(board.size()));

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board.size(); ++c)
            if(!visited[r][c]){
                BFS(board, visited, r, c);
                ++res;
            }

    return res;
}

void changeColor(vector<string>&board){
    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board.size(); ++c)
            if(board[r][c] == 'G')
                board[r][c] = 'R';
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<string> board(n);
    for(int i = 0; i < n; ++i)
        cin >> board[i];

    cout << section(board) << " ";

    changeColor(board);
    cout << section(board) << "\n";
    return 0;
}

```