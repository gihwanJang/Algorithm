#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

bool cmpToSecond(const pair<int,int>&a, const pair<int,int>&b){
    return a.second > b.second;
}

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<vector<int>> cmp = {{1,2,3,4,5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    pair<int,int> cerrect[3] = {make_pair(1,0), make_pair(2,0), make_pair(3,0)};

    for(int i = 0; i < answers.size(); ++i){
        if(answers[i] == cmp[0][i % 5]) ++cerrect[0].second;
        if(answers[i] == cmp[1][i % 8]) ++cerrect[1].second;
        if(answers[i] == cmp[2][i % 10]) ++cerrect[2].second;
    }

    sort(cerrect, cerrect + 3, cmpToSecond);
    answer.push_back(cerrect[0].first);

    for(int i = 1; i < 3; ++i){
        if(cerrect[i].second == cerrect[i - 1].second)
            answer.push_back(cerrect[i].first);
        else break;
    }
        
    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> answers = {1,3,2,4,2};    
    vector<int> answer = solution(answers);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << "\n";
    return 0;
}
