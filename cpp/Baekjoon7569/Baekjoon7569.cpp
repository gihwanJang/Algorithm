#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct point_3d{
    int z, x, y;
};


int count_day(vector<vector<vector<int>>>&matrix){
    int res = 0;
    point_3d p;
    queue<point_3d> que;

    for(int z = 0; z < matrix.size(); ++z)
        for(int x = 0; x < matrix[z].size(); ++x)
            for(int y = 0; y < matrix[z][x].size(); ++y)
                if(matrix[z][x][y] == 1)
                    que.push({z, x, y});

    while(!que.empty()){
        p = que.front();
        que.pop();

        // 상
        if(p.y < matrix[0][0].size()-1 && !matrix[p.z][p.x][p.y+1]){
            matrix[p.z][p.x][p.y+1] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x, p.y+1});
        }
        // 하
        if(p.y > 0 && !matrix[p.z][p.x][p.y-1]){
            matrix[p.z][p.x][p.y-1] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x, p.y-1});
        }
        // 좌
        if(p.x > 0 && !matrix[p.z][p.x-1][p.y]){
            matrix[p.z][p.x-1][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x-1, p.y});
        }
        // 우
        if(p.x < matrix[0].size()-1 && !matrix[p.z][p.x+1][p.y]){
            matrix[p.z][p.x+1][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z, p.x+1, p.y});
        }
        // 위
        if(p.z < matrix.size()-1 && !matrix[p.z+1][p.x][p.y]){
            matrix[p.z+1][p.x][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z+1, p.x, p.y});
        }
        // 아래
        if(p.z > 0 && !matrix[p.z-1][p.x][p.y]){
            matrix[p.z-1][p.x][p.y] = matrix[p.z][p.x][p.y] + 1;
            que.push({p.z-1, p.x, p.y});
        }
    }

    for(int z = 0; z < matrix.size(); ++z)
        for(int x = 0; x < matrix[z].size(); ++x)
            for(int y = 0; y < matrix[z][x].size(); ++y){
                if(matrix[z][x][y] == 0)
                    return -1;
                
                res = max(res, matrix[z][x][y]);
            }
    
    return res-1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, n, h;
    cin >> m >> n >> h;

    vector<vector<vector<int>>> matrix(h, 
        vector<vector<int>>(n, 
            vector<int>(m)
    ));
    for(int z = 0; z < h; ++z)
        for(int x = 0; x < n; ++x)
            for(int y = 0; y < m; ++y)
                cin >> matrix[z][x][y];
    
    cout << count_day(matrix) << "\n";
    return 0;
}
