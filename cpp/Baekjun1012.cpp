#include <cstdio>
#include <vector>
using namespace std;

void findNeighbors(vector<vector<bool>>&table, int x, int y){
    table[x][y] = false;
    if(x > 0 && table[x - 1][y])findNeighbors(table, x - 1, y);
    if(y > 0 && table[x][y - 1])findNeighbors(table, x, y - 1);
    if(x + 1 < table.size() && table[x + 1][y])findNeighbors(table, x + 1, y);
    if(y + 1 < table[0].size() && table[x][y + 1])findNeighbors(table, x, y + 1);
}

int main(int argc, char const *argv[]){
    int T;
    scanf("%d", &T);
    while(T--){
        int row, col, n, x, y, ans = 0;
        scanf("%d%d%d", &row, &col, &n);
        
        vector<vector<bool>> table (row,vector<bool>(col,false));
        for(int i = 0; i < n; ++i){
            scanf("%d%d", &x, &y);
            table[x][y] = true;
        }

        for(int r = 0; r  < row; ++r)
            for(int c = 0; c < col; ++c)
                if(table[r][c]){
                    findNeighbors(table, r, c);
                    ++ans;
                }

        printf("%d\n", ans);
    }
    return 0;
}
