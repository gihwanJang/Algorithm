#include <iostream>
#include <vector>

using namespace std;

bool canArrive(vector<vector<int>>&matrix, int r, int c){
    if(r == matrix.size() - 1 && c == matrix.size() - 1)
        return true;
        
    if(matrix[r][c] == 0)
        return false;

    if(matrix[r][c] + c < matrix.size())
        if(canArrive(matrix, r, c + matrix[r][c]))
            return true;

    if(matrix[r][c] + r < matrix.size())
        if(canArrive(matrix, r + matrix[r][c], c))
            return true;

    return false;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<vector<int>> matrix(n, vector<int>(n));
    for(int r = 0; r < n; ++r)
        for(int c = 0; c < n; ++c)
            cin >> matrix[r][c];

    cout << (canArrive(matrix, 0, 0) ? "HaruHaru" : "Hing") << "\n";
    return 0;
}
