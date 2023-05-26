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
