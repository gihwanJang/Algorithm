# (14500) 테트로미노
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/14500)

## 문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

- 정사각형은 서로 겹치면 안 된다.
- 도형은 모두 연결되어 있어야 한다.
- 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.

정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.

![14500_img1](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14500/1.png)

아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
#
## 입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
#
## 출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.
#
## 풀이
해당 문제는 dfs를 이용하여 해결할 수 있는 문제입니다.  

dfs를 이용하면 다른 도형들은 탐색이 가능하지만 ㅗ모양의 도형은 연속적인 모양이 아니기 때문에 따로 ㅗ,ㅜ,ㅏ,ㅓ 만을 따로 계산해 주면 됩니다.  

```cpp
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;
//ㅗ
int shape1(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r][c+1] + board[r][c+2] + board[r-1][c+1];
}
//ㅜ
int shape2(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r][c+1] + board[r][c+2] + board[r+1][c+1];
}
//ㅓ
int shape3(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r+1][c] + board[r+2][c] + board[r+1][c-1];
}
//ㅏ
int shape4(vector<vector<int>>&board, int r, int c){
    return board[r][c] + board[r+1][c] + board[r+2][c] + board[r+1][c+1];
}

int blocking(vector<vector<int>>&board, vector<vector<bool>>&visited, int r, int c, int depth){
    if(depth == 4) return board[r][c];

    int res = 0;

    if(r < board.size()-1 && !visited[r+1][c]){
        visited[r+1][c] = true;
        res = max(res, board[r][c]+blocking(board,visited,r+1,c,depth+1));
        visited[r+1][c] = false;
    }
    if(c > 0 && !visited[r][c-1]){
        visited[r][c-1] = true;
        res = max(res, board[r][c]+blocking(board,visited,r,c-1,depth+1));
        visited[r][c-1] = false;
    }
    if(c < board[0].size()-1 && !visited[r][c+1]){
        visited[r][c+1] = true;
        res = max(res, board[r][c]+blocking(board,visited,r,c+1,depth+1));
        visited[r][c+1] = false;
    }
    return res;
}

int tetromino(int n,int m, vector<vector<int>>&board){
    int res = 0;
    vector<vector<bool>> visited(n, vector<bool>(m));

    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c){
            visited[r][c] = true;
            res = max(res, blocking(board, visited, r, c, 1));
            visited[r][c] = false;

            if(r > 0 && c+2 < board[0].size())
                res = max(res, shape1(board,r,c));
            if(r+1 < board.size() && c+2 < board[0].size())
                res = max(res, shape2(board,r,c));
            if(r+2 < board.size() && c > 0)
                res = max(res, shape3(board,r,c));
            if(r + 2 < board.size() && c+1 < board[0].size())
                res = max(res, shape4(board,r,c));
        }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> board(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            cin >> board[r][c];

    cout << tetromino(n,m,board) << "\n";
    return 0;
}

```