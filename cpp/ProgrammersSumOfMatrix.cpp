#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    for(int r = 0; r < arr1.size(); ++r)
        for(int c = 0; c < arr1[r].size(); ++c)
            arr1[r][c] += arr2[r][c];
    return arr1;
}

int main(int argc, char const *argv[]){
    vector<vector<int>> arr1 = {{1},{2}};
    vector<vector<int>> arr2 = {{3},{4}};
    vector<vector<int>> answer = solution(arr1, arr2);
    for(int r = 0; r  < answer.size(); ++r){
        for(int c = 0; c < answer[r].size(); ++c)
            cout << "[" << answer[r][c] << "]";
        cout << "\n";
    }
    return 0;
}
