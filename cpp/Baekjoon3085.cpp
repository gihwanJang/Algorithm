#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int countChangeRow(vector<string>&board, int r, int c){
    int count, ans = 0;

    count = 1;
    for(int col = 0; col < board.size()-1; ++col){
        if(board[r][col] == board[r][col + 1]){
            ++count;
        }
        else{
            count = 1;
        }
        ans = max(ans, count);
    }
    count = 1;
    for(int r1 = 0; r1 < board.size()-1; ++r1){
        if(board[r1][c] == board[r1 + 1][c]){
            ++count;
        }
        else{
            count = 1;
        }
        ans = max(ans, count);
    }
    count = 1;
    for(int r2 = 0; r2 < board.size()-1; ++r2){
        if(board[r2][c - 1] == board[r2 + 1][c - 1]){
            ++count;
        }
        else{
            count = 1;
        }
        ans = max(ans, count);
    }

    return ans;
}

int countChangeCol(vector<string>&board, int r, int c){
    int count, ans = 0;
    count = 1;
    for(int row = 0; row < board.size()-1; ++row){
        if(board[row][c] == board[row + 1][c]){
            ++count;
        }
        else{
            count = 1;
        }
        ans = max(ans, count);
    }
    count = 1;
    for(int c1 = 0; c1 < board.size()-1; ++c1){
        if(board[r][c1] == board[r][c1 + 1]){
            ++count;
        }
        else{
            count = 1;
        }
        ans = max(ans, count);
    }
    count = 1;
    for(int c2 = 0; c2 < board.size()-1; ++c2){
        if(board[r - 1][c2] == board[r - 1][c2 + 1]){
            ++count;
        }
        else{
            count = 1;
        }
        ans = max(ans, count);
    }

    return ans;
}

void change(vector<string>&board, int r1, int c1, int r2, int c2){
    char tmp;
    tmp = board[r1][c1];
    board[r1][c1] = board[r2][c2];
    board[r2][c2] = tmp;
}

int changeLocation(vector<string>&board, int r, int c){
    int count = 0;

    if(r > 0){
        change(board, r, c, r - 1, c);
        count = max(count, countChangeCol(board, r, c));
        change(board, r, c, r - 1, c);
    }
    if(c > 0){
        change(board, r, c, r, c - 1);
        count = max(count, countChangeRow(board, r, c));
        change(board, r, c, r, c - 1);
    }
    return count;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, ans = 0;
    cin >> n;

    vector<string> board(n);
    for(int i = 0; i < n; ++i)
        cin >> board[i];
    
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            ans = max(ans, changeLocation(board, r, c));

    cout << ans << "\n";
    return 0;
}
