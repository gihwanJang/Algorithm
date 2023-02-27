#include <iostream>
#include <vector>

using namespace std;

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

void fillInTheBlank(vector<string>&board, int curr_r, int curr_c){
    int r, c;
    bool find = false;

    for(r = curr_r; r < 9; ++r){
        for(c = 0; c < 9; ++c){
            if(board[r][c] == '0'){
                find = true;
                break;
            }
        }
        if(find) break;
    }

    if(!find)
        return;

    for(int i = 1; i < 10; ++i)
        if(board[r][c] == '0' && check(board, r, c, i)){
            board[r][c] = 48+i;
            fillInTheBlank(board, r, c);
        }

    if(board[r][c] == '0')
        board[curr_r][curr_c] = '0';
}

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
