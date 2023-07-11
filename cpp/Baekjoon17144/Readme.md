# (17144) 미세먼지 안녕!
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/17144)
#
## 문제
미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다. 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다. 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다. (r, c)는 r행 c열을 의미한다.

![img1](https://upload.acmicpc.net/75d322ad-5a89-4301-b3a7-403fce0ff966/-/preview/)

공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.

1초 동안 아래 적힌 일이 순서대로 일어난다.

1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
    - (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
    - 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
    - 확산되는 양은 Ar,c/5이고 소수점은 버린다.
    - (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
2. 공기청정기가 작동한다.
    - 공기청정기에서는 바람이 나온다.
    - 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
    - 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
    - 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
다음은 확산의 예시이다.

![img2](https://upload.acmicpc.net/7b0d9d57-1296-44cd-8951-4135d27f9446/-/preview/)

왼쪽과 위쪽에 칸이 없기 때문에, 두 방향으로만 확산이 일어났다.

![img3](https://upload.acmicpc.net/cebebfa9-0056-45f1-b705-75b035888085/-/preview/)

인접한 네 방향으로 모두 확산이 일어난다.

![img4](https://upload.acmicpc.net/1ed0d2e9-9767-4b94-bbde-0e1d6a2d52ff/-/preview/)

공기청정기가 있는 칸으로는 확산이 일어나지 않는다.

공기청정기의 바람은 다음과 같은 방향으로 순환한다.

![img5](https://upload.acmicpc.net/94466937-96c7-4f25-9804-530ebd554a59/-/preview/)

방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.
#
## 입력
첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.

둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다. 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다. -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.
#
## 출력
첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.
#
## 풀이
해당 문제는 구현을 중점으로 둔 문제로 문제에서 제시한 것을 그대로 구현하면 해결 할 수 있습니다.

우선 먼지의 확산을 구현합니다.  
우선 먼지의 확산을 바로 구현하게 되면 확산된 먼지에 대한 확산을 연산 할 수 있음으로 확산된 먼지만을 표기할 별도의 테이블을 만듭니다.  
이후 모든 곳을 순회하며 값이 0보다 크면 확산을 시키고 본래의 값에 대한 반감은 원래의 테이블에 확산된 먼지는 별도의 테이블에 표기를 합니다.  
모든 먼지의 확산이 끝났다면 기존의 테이블과 별도로 만든 테이블을 합산합니다.  

이후 공기 청정기의 동작을 구현합니다.  
수행은 반 시계 방향이지만 구현은 시계방향으로 한칸씩 당기도록 구현합니다.  
이때 한칸씩 당긴후 공키 청정기의 옆의 칸은 항상 0의 값이 됩니다.

위의 구현된 것 들을 입력 받은 시간 만큼 반복한 후 테이블의 먼지의 총 합을 출력해주면 됩니다.

```cpp
#include <iostream>
#include <vector>

using namespace std;

struct Loc{
    int r, c;

    Loc(int row, int col):r(row), c(col){}
};

void spreadFineDust(vector<vector<int>>&board, Loc&cleaner)
{
    int r = board.size();
    int c = board[0].size();
    int count;

    vector<vector<int>> sub_board(board.size(), vector<int>(board[0].size()));

    for(int l_r = 0; l_r < r; ++l_r)
        for(int l_c = 0; l_c < c; ++l_c)
            if(board[l_r][l_c] > 0)
            {
                count = 0;
                // up
                if(0 <= l_r - 1 && !(l_r - 1 == cleaner.r && l_c == cleaner.c))
                {
                    sub_board[l_r-1][l_c] += board[l_r][l_c] / 5;
                    ++count;
                }
                // down
                if(l_r + 1 < r && !(l_r + 1 == cleaner.r - 1 && l_c == cleaner.c))
                {
                    sub_board[l_r+1][l_c] += board[l_r][l_c] / 5;
                    ++count;
                }
                // left
                if(0 <= l_c - 1 && !(l_c - 1 == cleaner.c && (l_r == cleaner.r || l_r == cleaner.r - 1)))
                {
                    sub_board[l_r][l_c-1] += board[l_r][l_c] / 5;
                    ++count;
                }
                // right
                if(l_c + 1 < c)
                {
                    sub_board[l_r][l_c+1] += board[l_r][l_c] / 5;
                    ++count;
                }

                board[l_r][l_c] -= (board[l_r][l_c] / 5) * count;
            }

    for(int l_r = 0; l_r < r; ++l_r)
        for(int l_c = 0; l_c < c; ++l_c)
            board[l_r][l_c] += sub_board[l_r][l_c];
}

void operateAirPurifier(vector<vector<int>>&board, Loc&cleaner)
{
    int r, c;

    for(r = cleaner.r-2, c = cleaner.c; 0 <= r-1; --r)
        board[r][c] = board[r-1][c];

    for(r = 0, c = cleaner.c; c+1 < board[0].size(); ++c)
        board[r][c] = board[r][c+1];

    for(r = 0, c = board[0].size()-1; r+1 < cleaner.r; ++r)
        board[r][c] = board[r+1][c];

    for(r = cleaner.r-1, c = board[0].size()-1; c-1 > 0; --c)
        board[r][c] = board[r][c-1];

    board[cleaner.r-1][1] = 0;

    for(r = cleaner.r+1, c = cleaner.c; r+1 < board.size(); ++r)
        board[r][c] = board[r+1][c];

    for(r = board.size()-1, c = cleaner.c; c+1 < board[0].size(); ++c)
        board[r][c] = board[r][c+1];

    for(r = board.size()-1, c = board[0].size()-1; r-1 >= cleaner.r; --r)
        board[r][c] = board[r-1][c];

    for(r = cleaner.r, c = board[0].size()-1; c-1 > 0; --c)
        board[r][c] = board[r][c-1];

    board[cleaner.r][1] = 0;
}

int getFineDustAmount(vector<vector<int>>&board, Loc&cleaner, int t)
{
    int mount = 0;

    while(t--)
    {
        spreadFineDust(board, cleaner);
        operateAirPurifier(board, cleaner);
    }

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board[0].size(); ++c)
            if(board[r][c] > 0)
                mount += board[r][c];

    return mount;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int r, c, t;
    cin >> r >> c >> t;

    Loc cleaner(0, 0);
    vector<vector<int>> board(r, vector<int>(c));
    for(int r_idx = 0; r_idx < r; ++r_idx)
        for(int c_idx = 0; c_idx < c; ++c_idx)
        {
            cin >> board[r_idx][c_idx];

            if(board[r_idx][c_idx] == -1)
                cleaner = Loc(r_idx, c_idx);
        }

    cout << getFineDustAmount(board, cleaner, t) << "\n";
    return 0;
}
```