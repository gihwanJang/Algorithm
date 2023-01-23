#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;


    vector<vector<int>> map(n, vector<int>(m));
    vector<vector<int>> check(n, vector<int>(m));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < m; ++c)
            cin >> map[r][c];

    check[0][0] = map[0][0];
    for(int r = 0; r < n; ++r)
        for(int c = 0; c< m; ++c){
            if(r+1 < n && check[r + 1][c] < check[r][c] + map[r+1][c]){
                check[r + 1][c] = check[r][c] + map[r+1][c];
            }
            if(r+1 < n && c+1 < m && check[r + 1][c + 1] < check[r][c] + map[r + 1][c + 1]){
                check[r + 1][c + 1] = check[r][c] + map[r + 1][c + 1];
            }
            if(c+1 < m && check[r][c + 1] < check[r][c] + map[r][c + 1]){
                check[r][c + 1] = check[r][c] + map[r][c + 1];
            }
        }

    cout << check[n-1][m-1] << "\n";
    return 0;
}
