#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void getMinMax(vector<int>&board, vector<pair<int,int>>&curr, vector<pair<int,int>>&next){
    for(int c = 0; c < 3; ++c){
            next[c].first = curr[c].first + board[c];
            next[c].second = curr[c].second + board[c];

            if(c > 0){
                next[c].first = min(next[c].first, curr[c-1].first + board[c]);
                next[c].second = max(next[c].second, curr[c-1].second + board[c]);
            }

            if(c < 2){
                next[c].first = min(next[c].first, curr[c+1].first + board[c]);
                next[c].second = max(next[c].second, curr[c+1].second + board[c]);
            }
        }

    for(int c = 0; c < 3; ++c)
        curr[c] = {next[c].first, next[c].second};
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, min_sum = 1234567891, max_sum = 0;
    cin >> n;

    vector<int> board(3);
    vector<pair<int,int>> curr(3);
    vector<pair<int,int>> next(3);
    
    for(int i = 0; i < 3; ++i){
        cin >> board[i];
        curr[i] = {board[i], board[i]};
    }

    for(int r = 1; r < n; ++r){
        for(int c = 0; c < 3; ++c)
            cin >> board[c];

        getMinMax(board, curr, next);
    }

    for(int i = 0; i < 3; ++i){
        min_sum = min(min_sum, curr[i].first);
        max_sum = max(max_sum, curr[i].second);
    }
    
    cout << max_sum << " " << min_sum << "\n";
    return 0;
}
