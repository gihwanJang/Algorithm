#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int clustering(vector<string>&matrix, vector<vector<bool>>&visited, int r, int c){
    int count = 1;
    visited[r][c] = true;

    if(r > 0 && matrix[r][c] == matrix[r - 1][c] && !visited[r - 1][c])
        count += clustering(matrix, visited, r - 1, c);
    if(r + 1 < matrix.size() && matrix[r][c] == matrix[r + 1][c] && !visited[r + 1][c])
        count += clustering(matrix, visited, r + 1, c);
    if(c > 0 && matrix[r][c] == matrix[r][c - 1] && !visited[r][ c - 1])
        count += clustering(matrix, visited, r, c - 1);
    if(c + 1 < matrix[0].length() && matrix[r][c] == matrix[r][c + 1] && !visited[r][ c + 1])
        count += clustering(matrix, visited, r, c + 1);

    return count;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int row, col, wc = 0, bc = 0 ;
    cin >> col >> row;

    vector<vector<bool>> visited(row, vector<bool>(col));
    vector<string> matrix(row);
    for(int r = 0; r < row; ++r)
        cin >> matrix[r];

    for(int r = 0; r < row; ++r)
        for(int c = 0; c < col; ++c)
            if(!visited[r][c]){
                if(matrix[r][c] == 'W')
                    wc += pow(clustering(matrix, visited, r, c),2);
                else
                    bc += pow(clustering(matrix, visited, r, c),2);
            }
    
    cout << wc << " " << bc << "\n";
    return 0;
}
