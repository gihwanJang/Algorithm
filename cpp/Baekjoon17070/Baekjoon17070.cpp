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
