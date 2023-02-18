#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, double>&a, const pair<int, double>&b){
    if(a.second > b.second) return true;
    else if(a.second < b.second) return false;
    else
        return a.first < b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int, double>> cmpArray;

    for(int i = 1; i <= N; ++i)
        cmpArray.push_back(make_pair(i, 0));

    for(int i = 0; i < stages.size(); ++i)
        if(stages[i] <= N) ++cmpArray[stages[i] - 1].second;

    for(int i = 0, total = stages.size(), tmp; i < N; ++i){
        tmp = cmpArray[i].second;
        cout << tmp << "/" << total <<"\n";
        if(total != 0) cmpArray[i].second /= total;
        total -= tmp;
    }

    sort(cmpArray.begin(), cmpArray.end(),cmp);

    for(int i = 0; i < N; ++i)
        answer.push_back(cmpArray[i].first);

    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> stages = {2,1,6,3,7};
    vector<int> answer = solution(9 , stages);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << ", ";
    cout << "\n";
    return 0;
}
