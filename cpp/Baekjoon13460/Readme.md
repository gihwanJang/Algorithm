# (13460) 구슬 탈출 2
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/13460)

## 문제
스타트링크에서 판매하는 어린이용 장난감 중에서 가장 인기가 많은 제품은 구슬 탈출이다. 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.

보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다. 게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.

이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다. 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.

각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.

보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.

## 입력
첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. '.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.

입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.

## 출력
최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.

## 풀이
해당 문제는 최대 칸수와 최대 깊이가 10으로 제한 되어있어 충분히 전수조사가 가능한 문제입니다.  

전수조사는 현제 조건에 대하여 상,하,좌,우 4가지를 살펴보면 됩니다.
해당 4가지의 경우 일일이 모두 코딩을 하면 중복되는 코드가 많음으로 전역으로 선언해 줍니다.  
또한 빨간 구슬과 파란 구슬의 위치 또한 매번 찾으면 비효율 적이므로 전역으로 선언하고 입력시에 1번 만 찾아 지정해 줍니다. 

```cpp
pair<int, int> red;
pair<int, int> blue;

vector<vector<int>> dir = {
    {-1,0},
    {1,0},
    {0,-1},
    {0,1}
};

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans;
    cin >> n >> m;

    vector<string> board(n);
    for(int r = 0; r < n; ++r){
        cin >> board[r];

        for(int c = 0; c < m; ++c){
            if(board[r][c] == 'R')
                red = make_pair(r, c);

            if(board[r][c] == 'B')
                blue = make_pair(r, c);
        }
    }

    ans = game(board, 0);
    cout << (ans == INF ? -1 : ans) << "\n";
    return 0;
}
```

입력을 완료 했다면 상하좌우 전수조사를 하며 최소 횟수를 찾아주면 됩니다.
이때 최대 10미만으로 실행해야하기 때문에 종료조건은 depth가 10일때가 됩니다. 

```cpp
int game(vector<string>&board, int depth){
    if(depth == 10) return INF;

    int res = INF;

    res = min(res, up(board, depth+1));
    res = min(res, down(board, depth+1));
    res = min(res, left(board, depth+1));
    res = min(res, right(board, depth+1));
    
    return res;
}
```

상,하,좌,우의 경우 탐색의 방식은 똑같기 때문에 상을 예롤 들어 설명하겠습니다.  
구슬을 옮겨가며 확인을 하는데 전수조사시 백트래킹을 이용하는 2가지 방법이 있습니다.  

1. 위로 기울였다면 다시 아래로 기울인다.
2. 기울이기전 위치를 기억해두고 해당 위치로 옮긴다.  

두가지 방법이 존재하지만 해당 문제에서 깊이는 최대 10으로 저장해 두는 위치도 최대 10개 밖에 안되기 때문에 이전의 위치를 기억해 두는 방식으로 구현합니다.  

이제 구슬을 옮겨야하는데 순서가 중요합니다.  
위쪽으로 기울이면 물리적으로 위에있는 구슬이 먼저 움직이게 되므로 위쪽에 있는 구슬과 아랫 쪽에 있는 구슬을 찾습니다.  

이때 주의할 것은 위치는 실제위치에 반영 되어야하기 때문에 (c++)의 경우 참조 연사자를 이용하여 위치를 선언해 주어야합니다.
그리고 해당 위치를 기억하여 따로 선언해 줍니다.  

이제 구슬의 위에 칸이 '.'이거나 'O'일때 구슬을 옮겨줍니다. 
옮기다 'O' 나온 경우 구슬들을 이전 위치로 되돌리고 'O'를 만난 구슬이 빨간색이고 파란색 구슬이 아랫쪽에 없다면 해당 깊이를 반환해 주면됩니다.  

```cpp
// 위로 움직이기 위한 함수
int up(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&up = red.first < blue.first ? red : blue;
    pair<int,int>&down = red.first < blue.first ? blue : red;
    pair<int,int> prev_up = make_pair(up.first, up.second);
    pair<int,int> prev_down = make_pair(down.first, down.second);

    if(move(board, depth, prev_up, prev_down, up, down, 0, 1, m_res))
        return m_res;
    if(move(board, depth, prev_down, prev_up, down, up, 0, 1, m_res))
        return m_res;

    res = min(res,game(board, depth));

    restore(board, prev_down, down);
    restore(board, prev_up, up);

    return res;
}
```

```cpp
// 실질적인 모든 움직임을 담당하는 함수
bool move(vector<string>&board, int depth, pair<int,int>&prev_f, pair<int,int>&prev_s, pair<int,int>&curr_f, pair<int,int>&curr_s, int d, int rd, int&res){
    while(board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] == '.' || board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] == 'O'){
        if(board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] == 'O'){
            restore(board, prev_s, curr_s);
            restore(board, prev_f, curr_f);
            res=board[curr_f.first][curr_f.second] == 'R' && !withRB(board,curr_f.first,curr_f.second, rd) ? depth : INF;
            return true;
        }

        board[curr_f.first+dir[d][0]][curr_f.second+dir[d][1]] = board[curr_f.first][curr_f.second];
        board[curr_f.first][curr_f.second] = '.';

        curr_f.first += dir[d][0];
        curr_f.second += dir[d][1];
    }

    return false;
}
```
```cpp
// 파란구슬도 같이 빠지는지 확인하는 함수
bool withRB(vector<string>&board, int r, int c, int d){
    for(; board[r][c] != '#'; r+=dir[d][0], c+=dir[d][1])
        if(board[r][c] == 'B')
            return true;

    return false;
}
```
```cpp
// 이전 상태로 복구하는 함수
void restore(vector<string>&board, pair<int, int>&prev, pair<int, int>&curr){
    if(prev.first != curr.first || prev.second != curr.second){
        board[prev.first][prev.second] = board[curr.first][curr.second];
        board[curr.first][curr.second] = '.';
        curr.first = prev.first;
        curr.second = prev.second;
    }
}
```

아래의 코드는 다른 방향으로 움직이는 함수롤 위로 움직이는 함수와 모든 형식이 동일 합니다.

```cpp
int down(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&up = red.first < blue.first ? red : blue;
    pair<int,int>&down = red.first < blue.first ? blue : red;
    pair<int,int> prev_up = make_pair(up.first, up.second);
    pair<int,int> prev_down = make_pair(down.first, down.second);

    if(move(board, depth, prev_down, prev_up, down, up, 1, 0, m_res))
        return m_res;
    if(move(board, depth, prev_up, prev_down, up, down, 1, 0, m_res))
        return m_res;

    res = min(res,game(board, depth));

    restore(board, prev_up, up);
    restore(board, prev_down, down);

    return res;
}
```
```cpp
int left(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&left = red.second < blue.second ? red : blue;
    pair<int,int>&right = red.second < blue.second ? blue : red;
    pair<int,int> prev_left = make_pair(left.first, left.second);
    pair<int,int> prev_right = make_pair(right.first, right.second);

    if(move(board, depth, prev_left, prev_right, left, right, 2, 3, m_res))
        return m_res;
    if(move(board, depth, prev_right, prev_left, right, left, 2, 3, m_res))
        return m_res;
    
    res = min(res,game(board, depth));

    restore(board, prev_right, right);
    restore(board, prev_left, left);

    return res;
}
```
```cpp
int right(vector<string>&board, int depth){
    int res = INF, m_res;

    pair<int,int>&left = red.second < blue.second ? red : blue;
    pair<int,int>&right = red.second < blue.second ? blue : red;
    pair<int,int> prev_left = make_pair(left.first, left.second);
    pair<int,int> prev_right = make_pair(right.first, right.second);

    if(move(board, depth, prev_right, prev_left, right, left, 3, 2, m_res))
        return m_res;
    if(move(board, depth, prev_left, prev_right, left, right, 3, 2, m_res))
        return  m_res;

    res = min(res,game(board, depth));

    restore(board, prev_left, left);
    restore(board, prev_right, right);

    return res;
}
```