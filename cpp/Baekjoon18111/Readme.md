# (18111) 마인크래프트
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/18111)

## 문제
팀 레드시프트는 대회 준비를 하다가 지루해져서 샌드박스 게임인 ‘마인크래프트’를 켰다. 마인크래프트는 1 × 1 × 1(세로, 가로, 높이) 크기의 블록들로 이루어진 3차원 세계에서 자유롭게 땅을 파거나 집을 지을 수 있는 게임이다.

목재를 충분히 모은 lvalue는 집을 짓기로 하였다. 하지만 고르지 않은 땅에는 집을 지을 수 없기 때문에 땅의 높이를 모두 동일하게 만드는 ‘땅 고르기’ 작업을 해야 한다.

lvalue는 세로 N, 가로 M 크기의 집터를 골랐다. 집터 맨 왼쪽 위의 좌표는 (0, 0)이다. 우리의 목적은 이 집터 내의 땅의 높이를 일정하게 바꾸는 것이다. 우리는 다음과 같은 두 종류의 작업을 할 수 있다.

1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.  

1번 작업은 2초가 걸리며, 2번 작업은 1초가 걸린다. 밤에는 무서운 몬스터들이 나오기 때문에 최대한 빨리 땅 고르기 작업을 마쳐야 한다. ‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하시오.

단, 집터 아래에 동굴 등 빈 공간은 존재하지 않으며, 집터 바깥에서 블록을 가져올 수 없다. 또한, 작업을 시작할 때 인벤토리에는 B개의 블록이 들어 있다. 땅의 높이는 256블록을 초과할 수 없으며, 음수가 될 수 없다.

## 입력
첫째 줄에 N, M, B가 주어진다. (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 107)

둘째 줄부터 N개의 줄에 각각 M개의 정수로 땅의 높이가 주어진다. (i + 2)번째 줄의 (j + 1)번째 수는 좌표 (i, j)에서의 땅의 높이를 나타낸다. 땅의 높이는 256보다 작거나 같은 자연수 또는 0이다.

## 출력
첫째 줄에 땅을 고르는 데 걸리는 시간과 땅의 높이를 출력하시오. 답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력하시오.

## 풀이
해당 문제는 높이의 최대가 256이므로 높이를 0~256까지 전부 찾아보면 됩니다.  

현재의 블록이 지으려는 높이보다 높으면 해당 높이에서 지으려는 높이의 갯수만큼을 b에 더해주고 시간은 2를 곱한 만큼 더해줍니다.  
반대로 작다면 지으려는 높이의 갯수에서 현재 높이를 뺀만큼 b에서 빼고 시간을 더해줍니다.  

이때 b가 음수가 되면 블록의 갯수가 부족한 것이므로 이후의 높이는 검사하지 않아도 됩니다.  
```cpp
#include <iostream>
#include <vector>

using namespace std;

bool flattening(vector<vector<int>>&board, int b, int cnt, int&res1, int&res2){
    int cost = 0;

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board[r].size(); ++c){
            if(board[r][c] >= cnt){
                cost += 2 * (board[r][c] - cnt);
                b += board[r][c] - cnt;
            }
            else{
                cost += cnt - board[r][c];
                b -= cnt - board[r][c];
            }
        }

    if(b < 0)
        return false;

    if(res1 >= cost){
        res1 = cost;
        res2 = cnt;
    }
    return true;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, b, ans1 = 1234567891, ans2 = 0;
    cin >> n >> m >> b;

    vector<vector<int>> board(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            cin >> board[r][c];

    for(int i = 0; i < 257; ++i)
        if(!flattening(board, b, i, ans1, ans2))
            break;
    
    cout << ans1 << " " << ans2 << "\n";
    return 0;
}

```