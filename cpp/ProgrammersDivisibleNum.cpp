#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    for(int i = 0; i < arr.size(); ++i)
        if(arr[i] % divisor == 0)
            answer.push_back(arr[i]);
    if(answer.size() != 0)
        sort(answer.begin(), answer.end());
    else
        answer.push_back(-1);
    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> arr = {1,2,3,4,15,10};
    vector<int> answer = solution(arr, 5);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << ", ";
    return 0;
}