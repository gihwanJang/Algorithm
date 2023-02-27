# (2239) 스도쿠
## :100: Algorithm
## 문제
스도쿠는 매우 간단한 숫자 퍼즐이다. 9×9 크기의 보드가 있을 때, 각 행과 각 열, 그리고 9개의 3×3 크기의 보드에 1부터 9까지의 숫자가 중복 없이 나타나도록 보드를 채우면 된다. 예를 들어 다음을 보자.

![Baekjoon2239 img1](https://www.acmicpc.net/JudgeOnline/upload/201008/sdk.png)

위 그림은 참 잘도 스도쿠 퍼즐을 푼 경우이다. 각 행에 1부터 9까지의 숫자가 중복 없이 나오고, 각 열에 1부터 9까지의 숫자가 중복 없이 나오고, 각 3×3짜리 사각형(9개이며, 위에서 색깔로 표시되었다)에 1부터 9까지의 숫자가 중복 없이 나오기 때문이다.

하다 만 스도쿠 퍼즐이 주어졌을 때, 마저 끝내는 프로그램을 작성하시오.

## 입력
9개의 줄에 9개의 숫자로 보드가 입력된다. 아직 숫자가 채워지지 않은 칸에는 0이 주어진다.

## 출력
9개의 줄에 9개의 숫자로 답을 출력한다. 답이 여러 개 있다면 그 중 사전식으로 앞서는 것을 출력한다. 즉, 81자리의 수가 제일 작은 경우를 출력한다.

## 풀이
해당 문제의 경우 백트래킹을 이용하여 문제를 해결하였습니다.  
우선 선형검색을 통해 0인 곳을 찾습니다.    
찾지 못한다면 해당 스토쿠는 모두 채워져 있음으로 끝냅니다.
찾았다면 해당 칸이 다시 0인지 확인 후 해당 자리에 1 ~ 9까지 수를 넣을 수 있다면 넣고 다음 칸을 탐색합니다.  
이때 다음 칸에서 어떠한 수도 넣지 못한다면 이전에 칸을 0으로 바꾸고 이전에 넣었던 수 보다 큰 수를 넣고 재 탐색 합니다.

```cpp
void fillInTheBlank(vector<string>&board, int curr_r, int curr_c){
    int r, c;
    bool find = false;
    // 빈칸 찾기
    for(r = curr_r; r < 9; ++r){
        for(c = 0; c < 9; ++c){
            if(board[r][c] == '0'){
                find = true;
                break;
            }
        }
        if(find) break;
    }
    // 못찾았을 경우
    if(!find)
        return;
    // 찾은 경우
    for(int i = 1; i < 10; ++i)
        if(board[r][c] == '0' && check(board, r, c, i)){
            board[r][c] = 48+i;
            fillInTheBlank(board, r, c);
        }
    // 해당 단계에서 넣을 수 있는 값이 없는 경우
    if(board[r][c] == '0')
        board[curr_r][curr_c] = '0';
}
```

위에서의 수를 넣을 수 있는지는 아래와 같이 판별 합니다.  

```cpp
bool check(vector<string>&board, int curr_r, int curr_c, int val){
    for(int r = 0; r < 9; ++r)
        if(board[r][curr_c] == 48 + val)
            return false;

    for(int c = 0; c < 9; ++c)
        if(board[curr_r][c] == 48 + val)
            return false;

    for(int r = curr_r/3*3; r < curr_r/3*3+3; ++r)
        for(int c = curr_c/3*3; c < curr_c/3*3+3; ++c)
            if(board[r][c] == 48 + val)
                return false;
                
    return true;
}
```

이후 완성된 스토쿠를 출력해 주면 해결 문제를 해결 할 수 있습니다.  

```cpp
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<string> board(9);
    for(int i = 0; i < 9; ++i)
        cin >> board[i];

    fillInTheBlank(board, 0, 0);

    for(int i = 0; i < 9; ++i)
        cout << board[i] << "\n";
    return 0;
}
```