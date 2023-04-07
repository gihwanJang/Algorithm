#include <unordered_set>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Shark{
    int x,y,size,eat;
    Shark() : x(0), y(0), size(2), eat(0){}
};

struct Point{
    int x, y, d;
    Point(int X, int Y, int D) : x(X), y(Y), d(D){}
};


bool BFS(vector<vector<int>>&board, Shark&s, int&ans){
    vector<vector<bool>> visited(board.size(),vector<bool>(board.size()));
    Point p(0,0,0);
    queue<Point> que;
    que.push(Point(s.x,s.y,0));
    visited[s.x][s.y] = true;

    while(!que.empty()){
        p = que.front();
        que.pop();

        if(p.d && board[p.x][p.y] && board[p.x][p.y] < s.size){
            while(!que.empty() && que.front().d == p.d){
                Point cmp = que.front();
                que.pop();

                if(board[cmp.x][cmp.y]&&board[cmp.x][cmp.y] < s.size){
                    if(p.x > cmp.x)
                        p = cmp;
                    else if(p.x == cmp.x && p.y > cmp.y)
                        p = cmp;
                }
            }

            board[s.x][s.y] = 0;
            board[p.x][p.y] = 9;
            
            s.x = p.x;
            s.y = p.y;
 
            ans += p.d;
            return true;
        }
        //up
        if(p.x > 0 && !visited[p.x-1][p.y] && board[p.x-1][p.y] <= s.size){
            que.push(Point(p.x-1, p.y, p.d+1));
            visited[p.x-1][p.y] = true;
        }
        //left
        if(p.y > 0 && !visited[p.x][p.y-1] && board[p.x][p.y-1] <= s.size){
            que.push(Point(p.x, p.y-1, p.d+1));
            visited[p.x][p.y-1] = true;
        }
        //right
        if(p.y < board.size()-1 && !visited[p.x][p.y+1] && board[p.x][p.y+1] <= s.size){
            que.push(Point(p.x, p.y+1, p.d+1));
            visited[p.x][p.y+1] = true;
        }
        //down
        if(p.x < board.size()-1 && !visited[p.x+1][p.y] && board[p.x+1][p.y] <= s.size){
            que.push(Point(p.x+1, p.y, p.d+1));
            visited[p.x+1][p.y] = true;
        }
    }
    return false;
}

int babyShark(vector<vector<int>>&board){
    int ans = 0;
    Shark s;
    for(int r = 0; r < board.size(); ++r){
        for(int c = 0; c < board.size(); ++c)
            if(board[r][c] == 9){
                s.x = r;
                s.y = c;
                break;
            }

        if(board[s.x][s.y] == 9) break;
    }

    while(BFS(board, s, ans))
        if(++s.eat == s.size){
            s.eat = 0;
            ++s.size;
        }
    
    return ans;
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

    cout << babyShark(board) << "\n";
    return 0;
}
