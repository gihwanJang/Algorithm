#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Location{
    int x, y, depth;
    bool can;

    Location(int X, int Y, int D, bool C): x(X), y(Y), depth(D), can(C){}
};

int BFS(string*board, int n, int m){
    vector<vector<bool>> visited_false(n, vector<bool>(m));
    vector<vector<bool>> visited_true(n, vector<bool>(m));
    Location curr(0,0,1,true);
    queue<Location> que;

    que.push(curr);
    visited_true[0][0] = true;

    while(!que.empty()){
        curr = que.front();
        que.pop();

        if(curr.x == n-1 && curr.y == m-1)
            return curr.depth;

        if(curr.can){
            if(curr.x > 0 && !visited_true[curr.x-1][curr.y]){
                que.push(Location(curr.x-1, curr.y, curr.depth+1, board[curr.x-1][curr.y] == '0'));

                if(board[curr.x-1][curr.y] == '0')
                    visited_true[curr.x-1][curr.y] = true;
                else
                    visited_false[curr.x-1][curr.y] = true;
            }
            if(curr.x < n-1 && !visited_true[curr.x+1][curr.y]){
                que.push(Location(curr.x+1, curr.y, curr.depth+1, board[curr.x+1][curr.y] == '0'));
                
                if(board[curr.x+1][curr.y] == '0')
                    visited_true[curr.x+1][curr.y] = true;
                else
                    visited_false[curr.x+1][curr.y] = true;
            }
            if(curr.y > 0 && !visited_true[curr.x][curr.y-1]){
                que.push(Location(curr.x, curr.y-1, curr.depth+1, board[curr.x][curr.y-1] == '0'));
                
                if(board[curr.x][curr.y-1] == '0')
                    visited_true[curr.x][curr.y-1] = true;
                else
                    visited_false[curr.x][curr.y-1] = true;
            }
            if(curr.y < m-1 && !visited_true[curr.x][curr.y+1]){
                que.push(Location(curr.x, curr.y+1, curr.depth+1, board[curr.x][curr.y+1] == '0'));
                
                if(board[curr.x][curr.y+1] == '0')
                    visited_true[curr.x][curr.y+1] = true;
                else
                    visited_false[curr.x][curr.y+1] = true;
            }
        }
        else{
            if(curr.x > 0 && !visited_false[curr.x-1][curr.y] && board[curr.x-1][curr.y] == '0'){
                que.push(Location(curr.x-1, curr.y, curr.depth+1, false));
                visited_false[curr.x-1][curr.y] = true;
            }
            if(curr.x < n-1 && !visited_false[curr.x+1][curr.y] && board[curr.x+1][curr.y] == '0'){
                que.push(Location(curr.x+1, curr.y, curr.depth+1, false));
                visited_false[curr.x+1][curr.y] = true;
            }
            if(curr.y > 0 && !visited_false[curr.x][curr.y-1] && board[curr.x][curr.y-1] == '0'){
                que.push(Location(curr.x, curr.y-1, curr.depth+1, false));
                visited_false[curr.x][curr.y-1] = true;
            }
            if(curr.y < m-1 && !visited_false[curr.x][curr.y+1] && board[curr.x][curr.y+1] == '0'){
                que.push(Location(curr.x, curr.y+1, curr.depth+1, false));
                visited_false[curr.x][curr.y+1] = true;
            }
        }
    }

    return -1;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    string*board = new string[n];

    for(int r = 0; r < n; ++r)
        cin >> board[r];

    cout << BFS(board, n, m) << "\n";
    return 0;
}
