#include<iostream>
#include<unordered_set>
using namespace std;

int solution(string s){
    unordered_set<string> set(1000);

    for(int i = 1; i <= s.size(); ++i)
        for(int j = 0; j+i <= s.size(); ++j)
            set.insert(s.substr(j,i));

    return set.size();
}

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;
    
    cout << solution(s) << "\n";
    return 0;
}
