#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    if(!arr.empty()) answer.push_back(arr[0]);
    for(int i = 1; i < arr.size(); ++i)
        if(answer.back() != arr[i])
            answer.push_back(arr[i]);
    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> arr = {4,4,4,3,3};
    vector<int> answer = solution(arr);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << "\n";
    return 0;
}
