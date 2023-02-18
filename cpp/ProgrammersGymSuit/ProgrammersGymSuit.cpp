#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n - lost.size();
    vector<bool> table(n + 2, false);
    
    for(int i = 0; i < reserve.size(); ++i)
        table[reserve[i]] = true;

    sort(lost.begin(), lost.end());

    for(int i = 0; i < lost.size(); ++i){
        if(table[lost[i] - 1]){
            ++answer;
            table[lost[i] - 1] = false;
        }
        else if(table[lost[i]]){
            ++answer;
            table[lost[i]] = false;
        }
        else if(table[lost[i] + 1]){
            ++answer;
            table[lost[i] + 1] = false;
        }
    }
    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> lost = {3};
    vector<int> reserve = {1};

    cout << solution(3, lost, reserve) << "\n";
    return 0;
}
