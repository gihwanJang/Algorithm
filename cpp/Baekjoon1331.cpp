#include <iostream>
#include <vector>

using namespace std;

struct point{
    int x, y;
};

bool check(point prev, point curr){
    if(prev.x + 2 == curr.x && prev.y + 1 == curr.y) return true;
    if(prev.x + 2 == curr.x && prev.y - 1 == curr.y) return true;

    if(prev.x - 2 == curr.x && prev.y + 1 == curr.y) return true;
    if(prev.x - 2 == curr.x && prev.y - 1 == curr.y) return true;

    if(prev.x + 1 == curr.x && prev.y + 2 == curr.y) return true;
    if(prev.x - 1 == curr.x && prev.y + 2 == curr.y) return true;

    if(prev.x + 1 == curr.x && prev.y - 2 == curr.y) return true;
    if(prev.x - 1 == curr.x && prev.y - 2 == curr.y) return true;

    return false;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<vector<bool>> board(6, vector<bool>(6));
    point prev, curr, start;
    string p;
    bool flag = true;
    
    cin >> p;
    start.x = prev.x = p[0] - 65;
    start.y = prev.y = p[1] - 49;
    board[start.x][start.y] = true;

    for(int i = 0; i < 35; ++i){
        cin >> p;
        curr.x = p[0] - 65;
        curr.y = p[1] - 49;

        if(!board[curr.x][curr.y] && check(prev, curr)){
            board[curr.x][curr.y] = true;
            prev = curr;
        }
        else
            flag = false;
    }
    cout << (check(curr, start) && flag ? "Valid" : "Invalid") << "\n";
    return 0;
}
