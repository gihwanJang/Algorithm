#include <iostream>
#include <vector>
#include <utility>

using namespace std;

vector<vector<bool>> board(8, vector<bool>(8));
pair<int, int> ston, king;

bool checkRange(int r, int c){
    return (r >= 0 && r < 8) && (c >= 0 && c < 8);
}

void move(string s){
    if(s == "R"){
        if(checkRange(king.first, king.second + 1)){
            if(king.first == ston.first && king.second + 1 == ston.second){
                if(checkRange(ston.first, ston.second + 1)){
                    board[ston.first][ston.second] = false;
                    ston.second += 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.second += 1;
            board[king.first][king.second] = true;
        }
    }
    else if(s == "L"){
        if(checkRange(king.first, king.second - 1)){
            if(king.first == ston.first && king.second - 1 == ston.second){
                if(checkRange(ston.first, ston.second - 1)){
                    board[ston.first][ston.second] = false;
                    ston.second -= 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.second -= 1;
            board[king.first][king.second] = true;
        }
    }
    else if(s == "B"){
        if(checkRange(king.first - 1, king.second)){
            if(king.first - 1 == ston.first && king.second == ston.second){
                if(checkRange(ston.first - 1, ston.second)){
                    board[ston.first][ston.second] = false;
                    ston.first -= 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.first -= 1;
            board[king.first][king.second] = true;
        }
    }
    else if(s == "T"){
        if(checkRange(king.first + 1, king.second)){
            if(king.first + 1 == ston.first && king.second == ston.second){
                if(checkRange(ston.first + 1, ston.second)){
                    board[ston.first][ston.second] = false;
                    ston.first += 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.first += 1;
            board[king.first][king.second] = true;
        }
    }
    else if(s == "RT"){
        if(checkRange(king.first + 1, king.second + 1)){
            if(king.first + 1 == ston.first && king.second + 1 == ston.second){
                if(checkRange(ston.first + 1, ston.second + 1)){
                    board[ston.first][ston.second] = false;
                    ston.first += 1;
                    ston.second += 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.first += 1;
            king.second += 1;
            board[king.first][king.second] = true;
        }
    }
    else if(s == "LT"){
        if(checkRange(king.first + 1, king.second - 1)){
            if(king.first + 1 == ston.first && king.second - 1 == ston.second){
                if(checkRange(ston.first + 1, ston.second - 1)){
                    board[ston.first][ston.second] = false;
                    ston.first += 1;
                    ston.second -= 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.first += 1;
            king.second -= 1;
            board[king.first][king.second] = true;
        }
    }
    else if(s == "RB"){
        if(checkRange(king.first - 1, king.second + 1)){
            if(king.first - 1 == ston.first && king.second + 1 == ston.second){
                if(checkRange(ston.first - 1, ston.second + 1)){
                    board[ston.first][ston.second] = false;
                    ston.first -= 1;
                    ston.second += 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.first -= 1;
            king.second += 1;
            board[king.first][king.second] = true;
        }
    }
    else{
        if(checkRange(king.first - 1, king.second - 1)){
            if(king.first - 1 == ston.first && king.second - 1 == ston.second){
                if(checkRange(ston.first - 1, ston.second - 1)){
                    board[ston.first][ston.second] = false;
                    ston.first -= 1;
                    ston.second -= 1;
                    board[ston.first][ston.second] = true;
                }
                else return;
            }
            board[king.first][king.second] = false;
            king.first -= 1;
            king.second -= 1;
            board[king.first][king.second] = true;
        }
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;

    cin >> s;
    king = make_pair(s[1] - 49, s[0] - 65);
    board[king.first][king.second] = true;
    cin >> s;
    ston = make_pair(s[1] - 49, s[0] - 65);
    board[ston.first][ston.second] = true;

    cin >> n;
    while(n--){
        cin >> s;
        move(s);
    }

    cout << char(king.second + 65) << char(king.first + 49) << "\n";
    cout << char(ston.second + 65) << char(ston.first + 49) << "\n";
    return 0;
}
