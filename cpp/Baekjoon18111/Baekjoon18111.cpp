#include <iostream>
#include <vector>

using namespace std;

bool flattening(vector<vector<int>>&board, int b, int cnt, int&res1, int&res2){
    int cost = 0;

    for(int r = 0; r < board.size(); ++r)
        for(int c = 0; c < board[r].size(); ++c){
            if(board[r][c] >= cnt){
                cost += 2 * (board[r][c] - cnt);
                b += board[r][c] - cnt;
            }
            else{
                cost += cnt - board[r][c];
                b -= cnt - board[r][c];
            }
        }

    if(b < 0)
        return false;

    if(res1 >= cost){
        res1 = cost;
        res2 = cnt;
    }
    return true;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, b, ans1 = 1234567891, ans2 = 0;
    cin >> n >> m >> b;

    vector<vector<int>> board(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            cin >> board[r][c];

    for(int i = 0; i < 257; ++i)
        if(!flattening(board, b, i, ans1, ans2))
            break;
    
    cout << ans1 << " " << ans2 << "\n";
    return 0;
}
