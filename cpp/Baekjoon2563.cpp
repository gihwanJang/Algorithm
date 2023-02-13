#include <iostream>
#include <vector>

using namespace std;

void drawing(vector<vector<bool>>&matrix, int x, int y, int&ans){
    for(int r = x; r - x < 10; ++r)
        for(int c = y; c - y < 10; ++c){
            if(matrix[r][c]) continue;
            matrix[r][c] = true;
            ++ans;
        }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<vector<bool>> matrix(100, vector<bool>(100));

    int n, x, y, ans = 0;
    cin >> n;

    while(n--){
        cin >> x >> y;
        drawing(matrix, x - 1, y - 1, ans);
    }

    cout << ans << "\n";
    return 0;
}
