#include<iostream>
#include<vector>
using namespace std;

int board[9][9];
vector< pair<int,int> > zeros;

bool check(int r, int c, int num){
    for(int i = 0; i < 9; ++i){
        if(board[r][i] == num) return false;
        if(board[i][c] == num) return false;
        if(board[3*(r/3) + (i/3)][3*(c/3) + (i%3)] == num)
            return false;
    }
    return true;
}

bool sudoku(int index){
    if(index == zeros.size()) return true;
    
    for(int num = 1; num < 10; ++num)
        if(check(zeros[index].first, zeros[index].second, num)){
            board[zeros[index].first][zeros[index].second] = num;
            if(sudoku(index+1)) break;
            board[zeros[index].first][zeros[index].second] = 0;
        }
    
    return board[zeros[index].first][zeros[index].second] == 0 ? false : true;
}

int main(int argc, char const *argv[]){
    for(int r = 0; r < 9; ++r)
        for(int c = 0; c < 9; ++c){
            scanf("%d", &board[r][c]);
            if(board[r][c] == 0)
                zeros.push_back(make_pair(r,c));
        }
    
    sudoku(0);

    for(int r = 0; r < 9; ++r){
        for(int c = 0; c < 9; ++c)
            printf("%d ", board[r][c]);
        printf("\n");
    }        
    return 0;
}
