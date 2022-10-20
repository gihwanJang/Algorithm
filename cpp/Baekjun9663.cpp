#include<iostream>
#include<vector>
using namespace std;

int n, cnt = 0;

bool promise(const vector< vector<bool> >&board, int row, int col){
    for(int i = 1; row >= i; ++i){
        if(board[row-i][col])
            return false;
        if(col >= i && board[row-i][col-i])
            return false;
        if(col+i < n && board[row-i][col+i])
            return false;
    }
    
    return true;
}

void nQueen(vector< vector<bool> >&board, int row){
    if(row == n){
        ++cnt;
        return;
    }

    for(int col = 0; col < n; ++col)
        if(promise(board, row, col)){
            board[row][col] = true;
            nQueen(board, row+1);
            board[row][col] = false;
        }
}

int main(int argc, char const *argv[]){
    scanf("%d", &n);

    vector< vector<bool> > board(n);
    for(int i = 0; i < n; ++i){
        vector<bool> row(n,false);
        board[i] = row;
    }

    nQueen(board, 0);

    printf("%d\n", cnt);
    return 0;
}
