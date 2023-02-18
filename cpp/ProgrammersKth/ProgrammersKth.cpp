#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int findKth(const vector<int>&array, const vector<int>&commend){
    vector<int> tmp;
    for(int i = commend[0] - 1; i < commend[1]; ++i)
        tmp.push_back(array[i]);
    sort(tmp.begin(), tmp.end());
    return tmp[commend[2] - 1];
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for(int i = 0; i < commands.size(); ++i)
        answer.push_back(findKth(array, commands[i]));

    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> array = {1, 5, 2, 6, 3, 7, 4}; 
    vector<vector<int>> commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    vector<int> answer = solution(array, commands);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << ",";
    return 0;
}
