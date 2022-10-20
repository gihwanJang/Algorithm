#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, row = 0, col = 0;
    cin >> N;

    vector<string> matrix(N);
    for(int i = 0; i < N; ++i)
        cin >> matrix[i];

    for(int r = 0; r < N; ++r){
        int row_count = 0, col_count = 0;
        for(int c = 0; c < N; ++c){
            if(matrix[r][c] != 'X')
                ++row_count;
            else{
                if(row_count > 1) ++row;
                row_count = 0;
            }
            if(matrix[c][r] != 'X')
                ++col_count;
            else{
                if(col_count > 1) ++col;
                col_count = 0;
            }
        }
        if(row_count > 1) ++row;
        if(col_count > 1) ++col;
    }

    cout << row << " " << col << "\n";
    return 0;
}
