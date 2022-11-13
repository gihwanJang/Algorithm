#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, r = 0, c = 0, count = 1;
    cin >> N >> M;

    vector<vector<bool>> matrix(N,vector<bool>(M,false));

    while(count < N * M){
        while(true){
            matrix[r][c] = true;
            if(r + 1 < N && !matrix[r + 1][c]){
                ++r;
                ++count;
            }
            else break;
        }
        while(true){
            matrix[r][c] = true;
            if(c + 1 < M && !matrix[r][c + 1]){
                ++c;
                ++count;
            }
            else break;
        }
        while(true){
            matrix[r][c] = true;
            if(r - 1 > -1 && !matrix[r - 1][c]){
                --r;
                ++count;
            }
            else break;
        }
        while(true){
            matrix[r][c] = true;
            if(c - 1 > -1 && !matrix[r][c - 1]){
                --c;
                ++count;
            }
            else break;
        }
    }

    cout << r << " " << c << "\n";
    return 0;
}
