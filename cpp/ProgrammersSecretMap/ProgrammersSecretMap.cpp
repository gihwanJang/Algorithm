#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    for(int i = 0; i < n; ++i){
        int decryptValue = arr1[i] | arr2[i];
        string decryptStr = "";
        for(int j = 0; j < n; ++j)
            decryptStr += (decryptValue >> j) & 1 ? "#" : " ";
        reverse(decryptStr.begin(),decryptStr.end());
        answer.push_back(decryptStr);
    }
    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> arr1 = {9, 20, 28, 18, 11};
    vector<int> arr2 = {30, 1, 21, 17, 28};
    vector<string> answer = solution(5, arr1, arr2);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << "\n";
    return 0;
}
