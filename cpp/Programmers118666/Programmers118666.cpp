#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    unordered_map<char, int> scores(16);
    char character[4][2] = {{'R', 'T'},{'C', 'F'},{'J', 'M'},{'A', 'N'}};
    
    //map 초기화
    for(int i = 0; i < 4; ++i)
        for(int j = 0; j < 2; ++j)
            scores.insert(make_pair(character[i][j], 0));
    //유형별 점수 계산
    for(int i = 0, score; i < survey.size(); ++i){
        if(choices[i] < 4)
            scores.find(survey[i][0]) -> second -= choices[i] - 4;
        else
            scores.find(survey[i][1]) -> second += choices[i] - 4;
    }
    //유형 판별
    for(int i = 0; i < 4; ++i){
        if(scores.find(character[i][0])->second < scores.find(character[i][1])->second)
            answer.push_back(character[i][1]);
        else
            answer.push_back(character[i][0]);
    }
    
    return answer;
}

int main(int argc, char const *argv[]){
    vector<string> survey = {"AN", "CF", "MJ", "RT", "NA"};
    vector<int> choices = {5, 3, 2, 7, 5};
    cout << solution(survey, choices) << "\n";
    return 0;
}
