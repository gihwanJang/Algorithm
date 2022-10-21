#include <iostream>
#include <vector>

using namespace std;

int N;

int solution(const vector<string>&matrix){
    int ans = 0;

    for(int i = 0; i < N; ++i){
        int node = 0;
        vector<bool> visited(N, false);
        vector<int> stack;
        visited[i] = true;
        for(int j = 0; j < N; ++j)
            if(matrix[i][j] == 'Y'){
                visited[j] = true;
                stack.push_back(j);
                ++node;
            }
        while(!stack.empty()){
            int k = stack.back();
            stack.pop_back();
            for(int l = 0; l < N; ++l)
                if(matrix[k][l] == 'Y' && !visited[l]){
                    visited[l] = true;
                    ++node;
                }
        }
        ans = max(ans, node);
    }

    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    vector<string> matrix(N);
    for(int i = 0; i < N; ++i)
        cin >> matrix[i];

    cout << solution(matrix) << "\n";
    return 0;
}
