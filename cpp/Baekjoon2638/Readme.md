# (2638) 치즈
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/2638)
#
## 문제
N×M의 모눈종이 위에 아주 얇은 치즈가 <그림 1>과 같이 표시되어 있다. 단, N 은 세로 격자의 수이고, M 은 가로 격자의 수이다. 이 치즈는 냉동 보관을 해야만 하는데 실내온도에 내어놓으면 공기와 접촉하여 천천히 녹는다. 그런데 이러한 모눈종이 모양의 치즈에서 각 치즈 격자(작 은 정사각형 모양)의 4변 중에서 적어도 2변 이상이 실내온도의 공기와 접촉한 것은 정확히 한시간만에 녹아 없어져 버린다. 따라서 아래 <그림 1> 모양과 같은 치즈(회색으로 표시된 부분)라면 C로 표시된 모든 치즈 격자는 한 시간 후에 사라진다.

![img1](https://upload.acmicpc.net/a4998beb-104c-4e37-b3d7-fd91cd81464a/-/preview/)

<그림 1>

<그림 2>와 같이 치즈 내부에 있는 공간은 치즈 외부 공기와 접촉하지 않는 것으로 가정한다. 그러므 로 이 공간에 접촉한 치즈 격자는 녹지 않고 C로 표시된 치즈 격자만 사라진다. 그러나 한 시간 후, 이 공간으로 외부공기가 유입되면 <그림 3>에서와 같이 C로 표시된 치즈 격자들이 사라지게 된다.

![img2](https://upload.acmicpc.net/e5d519ee-53ea-40a6-b970-710cca0db128/-/preview/)

<그림 2>

![img3](https://upload.acmicpc.net/a00b876a-86dc-4a82-a030-603a9b1593cc/-/preview/)

<그림 3>

모눈종이의 맨 가장자리에는 치즈가 놓이지 않는 것으로 가정한다. 입력으로 주어진 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간을 구하는 프로그램을 작성하시오.
#
## 입력
첫째 줄에는 모눈종이의 크기를 나타내는 두 개의 정수 N, M (5 ≤ N, M ≤ 100)이 주어진다.  

그 다음 N개의 줄에는 모눈종이 위의 격자에 치즈가 있는 부분은 1로 표시되고, 치즈가 없는 부분은 0으로 표시된다. 또한, 각 0과 1은 하나의 공백으로 분리되어 있다.
#
## 출력
출력으로는 주어진 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간을 정수로 첫 줄에 출력한다.
#
## 풀이
해당 문제는 BFS를 이용하면 해결 할 수 있는 문제입니다.  

우선 BFS를 통해 공기와 접촉하는 면을 구하는 함수 setTable 부분을 구현해 줍니다. 

이후 접촉면에 대하여 canMelt함수로 녹을 수 있는 부분인지 판단 후 녹을 수 있는 부분을 모두 녹이고 다시 setTable함수를 통해 접촉면을 재구성 합니다. 

해당 과정을 치즈가 없을 때 까지 반복후 최종 시간을 출력해 주시면 됩니다.

```cpp
#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 좌표 구조체
struct Loc{
    int r, c;

    Loc(int R, int C): r(R), c(C){}
};

// BFS를 이용하여 외부 공기와 접촉하는 부분만 표기
void setTable(vector<vector<bool>>&board, vector<vector<bool>>&table, int n, int m){
    Loc curr(0,0);
    queue<Loc> que;
    vector<vector<bool>> visited(n, vector<bool>(m));

    que.push(curr);
    table[curr.r][curr.c] = false;
    visited[curr.r][curr.c] = true; 

    while(!que.empty()){
        curr = que.front();
        que.pop();

        if(curr.r > 0 && !visited[curr.r-1][curr.c] && !board[curr.r-1][curr.c]){
            que.push(Loc(curr.r-1, curr.c));
            table[curr.r-1][curr.c] = false;
            visited[curr.r-1][curr.c] = true;
        }
        if(curr.c > 0 && !visited[curr.r][curr.c-1] && !board[curr.r][curr.c-1]){
            que.push(Loc(curr.r, curr.c-1));
            table[curr.r][curr.c-1] = false;
            visited[curr.r][curr.c-1] = true;
        }
        if(curr.r < n-1 && !visited[curr.r+1][curr.c] && !board[curr.r+1][curr.c]){
            que.push(Loc(curr.r+1, curr.c));
            table[curr.r+1][curr.c] = false;
            visited[curr.r+1][curr.c] = true;
        }
        if(curr.c < m-1 && !visited[curr.r][curr.c+1] && !board[curr.r][curr.c+1]){
            que.push(Loc(curr.r, curr.c+1));
            table[curr.r][curr.c+1] = false;
            visited[curr.r][curr.c+1] = true;
        }
    }
}

// 녹을 수 있는지 판별
bool canMelt(vector<vector<bool>>&table, Loc l, int n, int m){
    if(!table[l.r][l.c]) return false;

    int area = 0;

    // 접촉면 갯수 카운팅
    area += (!table[l.r-1][l.c]);
    area += (!table[l.r][l.c-1]);
    area += (!table[l.r+1][l.c]);
    area += (!table[l.r][l.c+1]);

    // 2개 이상이면 녹일 수 있음
    return (area > 1);
}

// 모두 녹는 시간을 도출
int getMeltTime(vector<vector<bool>>&board, int n, int m){
    int res = 0;
    vector<vector<bool>> table(n, vector<bool>(m, true));

    for(bool flag = true; flag; ++res){
        // 외부 접촉부를 갱신
        setTable(board, table, n, m);
        flag = false;

        // 녹을 수 있는 부분을 녹임
        for(int r = 1; r < n-1; ++r)
            for(int c = 1; c < m-1; ++c)
                if(canMelt(table, Loc(r, c), n, m)){
                    board[r][c] = false;
                    flag = true;
                }
    }

    return res - 1;
}

// 입출력
int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, v;
    cin >> n >> m;

    vector<vector<bool>> board(n, vector<bool>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c){
            cin >> v;
            board[r][c] = v;
        }

    cout << getMeltTime(board, n, m) << "\n";
    return 0;
}
```