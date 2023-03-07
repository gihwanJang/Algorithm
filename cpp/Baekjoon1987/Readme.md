# (1987) 알파벳

## :100: Algorithm

## 문제
세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.

말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.

좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.

## 입력
첫째 줄에 R과 C가 빈칸을 사이에 두고 주어진다. (1 ≤ R,C ≤ 20) 둘째 줄부터 R개의 줄에 걸쳐서 보드에 적혀 있는 C개의 대문자 알파벳들이 빈칸 없이 주어진다.

## 출력
첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다.

## 풀이
해당 문제의 경우 보드에 대하여 가능한 모든 경우를 방문하여 답을 구할 수 있습니다.  
우선 아래와 같은 전역 변수를 선언하여 사용하였습니다.  

스펠링은 A ~ Z 까지 26개 이므로 굳이 set에 넣어 찾는거 보다 26개의 배열을 만들어 체크하는 것이 좋을 것 같아 전역으로 두고 사용하였고  go배열은 상하좌우를 방문할 수 있음으로 상하좌우 4줄 치는 것이 귀찮아 배열로 만들어 놓고 반복문을 돌렸습니다.  

```cpp
vector<bool> spelling(26);

vector<vector<int>> go = {
    {-1, 0},
    {1, 0},
    {0, -1},
    {0, 1}
};
```

직접 방문하는 코드는 아래와 같습니다.  

- 현재의 위치는 한번 방문했음으로 visited를 true로 해주고 방문한 알파벳 또한 true로 바꿔 줍니다.  
- 상하좌우 방문이 가증한지 체크한다음 방문이 가능하다면 해당 위치로 이동합니다.  
- 방문이 끝나면 값을 갱신하여 반환하게 되므로 현제 위치는 다시 방문하지 않은 것으로 즉 visited를 false로 주고 현재 칸의 알파벳 또한 false로 바꿔줍니다.  

위의 과정이 끝나면 결과를 반환합니다.  

```cpp
int travelAllPath(vector<string>&board, vector<vector<bool>>&visited, int r, int c, int curr){
    int res = curr;

    visited[r][c] = true;
    spelling[board[r][c] - 65] = true;

    for(int i = 0; i < 4; ++i)
        if(isCanMove(board, visited, r + go[i][0], c + go[i][1]))
            res = max(res, travelAllPath(board, visited, r + go[i][0], c + go[i][1], curr+1));

    visited[r][c] = false;
    spelling[board[r][c] - 65] = false;

    return res;
}
```

방문 체크 코드의 경우 아래와 같습니다.  

- 범위 체크
- 방문한 칸인지 체크
- 방문한 알파벳인지 체크  

위의 경우가 모두 해당 안되면 방문 가능한 칸입니다.  

```cpp
bool isCanMove(vector<string>&board, vector<vector<bool>>&visited, int r, int c){
    if((r < 0 || r == board.size()) || (c < 0 || c == board[0].size()))
        return false;
    if(visited[r][c]) return false;
    if(spelling[board[r][c]-65]) return false;
    return true;
}
```

최종적으로 출력만 해주면 됩니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int r, c;
    cin >> r >> c;

    vector<string> board(r);
    vector<vector<bool>> visited(r, vector<bool>(c));
    for(int i = 0; i < r; ++i)
        cin >> board[i];

    cout << travelAllPath(board, visited, 0, 0, 1) << "\n";
    return 0;
}
```