#include <iostream>
#include <vector>

using namespace std;

int N, M;

bool checkRange(int r, int c){
    return r >= N || c >= M ? false : true;
}

int solution(const vector<vector<int>>&matrix, int row, int col, int cnt){
    int square = 0;

    if(checkRange(row + cnt, col + cnt))
        if(matrix[row][col] == matrix[row + cnt][col] && 
            matrix[row][col] == matrix[row][col + cnt] && 
            matrix[row][col] == matrix[row + cnt][col + cnt])
            square = cnt + 1;

    if(checkRange(row + cnt, col + cnt))
        square = max(square, solution(matrix, row, col, cnt + 1));

    return square;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    int answer = 0;
    string s;
    vector<vector<int>> matrix(N, vector<int>(M));

    for(int r = 0; r < N; ++r){
        cin >> s;
        for(int c = 0; c < M; ++c)
            matrix[r][c] = s[c] - 48;
    }

    for(int r = 0; r < N; ++r)
        for(int c = 0; c < M; ++c)
            answer = max(answer, solution(matrix, r, c, 0));

    cout << answer * answer << "\n";
    return 0;
}
 