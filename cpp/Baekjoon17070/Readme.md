# (17070) 파이프 옮기기 1
## :100: Algorithm
## 문제
유현이가 새 집으로 이사했다. 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 (r, c)로 나타낼 수 있다. 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 각각의 칸은 빈 칸이거나 벽이다.

오늘은 집 수리를 위해서 파이프 하나를 옮기려고 한다. 파이프는 아래와 같은 형태이고, 2개의 연속된 칸을 차지하는 크기이다.

![img_1](https://upload.acmicpc.net/3ceac594-87df-487d-9152-c532f7136e1e/-/preview/)

파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다.

![img_2](https://upload.acmicpc.net/b29efafa-dbae-4522-809c-76d5c184a231/-/preview/)

파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다. 벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안 된다. 즉, 파이프는 항상 빈 칸만 차지해야 한다.

파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다. 파이프는 밀면서 회전시킬 수 있다. 회전은 45도만 회전시킬 수 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.

파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가 있다.

아래 그림은 파이프가 놓여진 방향에 따라서 이동할 수 있는 방법을 모두 나타낸 것이고, 꼭 빈 칸이어야 하는 곳은 색으로 표시되어져 있다.

![img_3](https://upload.acmicpc.net/0f445b26-4e5b-4169-8a1a-89c9e115907e/-/preview/)

가로

![img_4](https://upload.acmicpc.net/045d071f-0ea2-4ab5-a8db-61c215e7e7b7/-/preview/)

세로

![img_5](https://upload.acmicpc.net/ace5e982-6a52-4982-b51d-6c33c6b742bf/-/preview/)

대각선

가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수를 구해보자.
#
## 입력
첫째 줄에 집의 크기 N(3 ≤ N ≤ 16)이 주어진다. 둘째 줄부터 N개의 줄에는 집의 상태가 주어진다. 빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.
#
## 출력
첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 이동시킬 수 없는 경우에는 0을 출력한다. 방법의 수는 항상 1,000,000보다 작거나 같다.
#
## 풀이
해당 문제의 경우 백트래킹을 이용하면 해결 할 수 있습니다.  

우선 격자판의 정보를 입력받습니다.  

입력이 끝나면 해당 판을 이용하여 백트래킹을 시작합니다.  
이때 백트래킹의 시작은 파이프의 시작 위치인 (0,0), (0,1)에서 시작합니다.  

1. 가로인 경우
    - 우측, 대각 방향으로 보냅니다.
2. 세로인 경우
    - 아래, 대각 방향으로 보냅니다.
3. 대각인 경우
    - 우측, 아래, 대각 방향으로 보냅니다.  

위의 경우는 모두 보낼 수 있는 경우에만 보내주면 됩니다.  

최종적으로 (n-1,n-1)에 도달하게 되면 값을 누적하여 최종적으로 출력해 줍니다.

<코드>
```cpp
#include <iostream>
#include <vector>

using namespace std;

struct pipe {
    int r1, c1, r2, c2;

    pipe(int R1, int C1, int R2, int C2):r1(R1), c1(C1), r2(R2), c2(C2){}
};

int movePipe(vector<vector<int>>&board, int n, pipe p){
    if(p.r2 == n-1 && p.c2 == n-1)
        return 1;
    
    int res = 0;
    
    if(p.r1 == p.r2){
        if(p.c2 < n-1 && !board[p.r2][p.c2+1]){
            res += movePipe(board, n, pipe(p.r2, p.c2, p.r2, p.c2+1));
            if(p.r2 < n-1 && !board[p.r2+1][p.c2+1] && !board[p.r2+1][p.c2])
                res += movePipe(board, n, pipe(p.r2, p.c2, p.r2+1, p.c2+1));
        }
    }
    else if(p.c1 == p.c2){
        if(p.r2 < n-1 && !board[p.r2+1][p.c2]){
            res += movePipe(board, n, pipe(p.r2, p.c2, p.r2+1, p.c2));
            if(p.c2 < n-1 && !board[p.r2+1][p.c2+1] && !board[p.r2][p.c2+1])
                res += movePipe(board, n, pipe(p.r2, p.c2, p.r2+1, p.c2+1));
        }
    }
    else{
        if(p.r2 < n-1 && !board[p.r2+1][p.c2]){
            res += movePipe(board, n, pipe(p.r2, p.c2, p.r2+1, p.c2));
            if(p.c2 < n-1 && !board[p.r2+1][p.c2+1] && !board[p.r2][p.c2+1])
                res += movePipe(board, n, pipe(p.r2, p.c2, p.r2+1, p.c2+1));
        }
        if(p.c2 < n-1 && !board[p.r2][p.c2+1])
            res += movePipe(board, n, pipe(p.r2, p.c2, p.r2, p.c2+1));
    }

    return res;
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

    cout << movePipe(board, n, pipe(0,0,0,1)) << "\n";
    return 0;
}
``` 