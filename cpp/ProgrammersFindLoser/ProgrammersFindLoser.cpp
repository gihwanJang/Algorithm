#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> map(participant.size() * 2);
    for(int i = 0; i < participant.size(); ++i){
        if(map.count(participant[i]))
            ++map.find(participant[i])->second;
        else
            map.insert(make_pair(participant[i], 1));
    }

    for(int i = 0; i < completion.size(); ++i){
        if(map.find(completion[i])->second == 1)
            map.erase(completion[i]);
        else
            --map.find(completion[i])->second;
    }
        
    return map.begin()->first;
}

int main(int argc, char const *argv[]){
    vector<string> participant = {"mislav", "stanko", "mislav", "ana"};
    vector<string> completion = {"stanko", "ana", "mislav"};
    cout << solution(participant, completion) << "\n";
    return 0;
}
