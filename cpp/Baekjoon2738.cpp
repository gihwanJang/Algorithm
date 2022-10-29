#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> matrix(N, vector<int>(M));
    for(int r = 0; r < N; ++r)
        for(int c = 0; c < M; ++c)
            cin >> matrix[r][c];

    for(int r = 0, k; r < N; ++r)
        for(int c = 0; c < M; ++c){
            cin >> k;
            matrix[r][c] += k;
        }

    for(int r = 0; r < N; ++r){
        for(int c = 0; c < M; ++c)
            cout << matrix[r][c] << " ";
        cout << "\n";
    }
    return 0;
}
