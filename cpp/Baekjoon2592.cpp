#include <iostream>
#include <utility>
#include <unordered_map>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum = 0, score;
    pair<int,int> most;
    unordered_map<int, int> scores;

    for(int i = 0; i < 10; ++i){
        cin >> score;
        sum += score;
        if(scores.count(score))
            ++scores.find(score)->second;
        else
            scores.insert({score,1});
    }

    most = make_pair(scores.begin()->first, scores.begin()->second);
    for(pair<int,int> s : scores)
        if(most.second < s.second)
            most = make_pair(s.first, s.second);

    cout << sum / 10 << "\n";
    cout << most.first << "\n";
    return 0;
}
