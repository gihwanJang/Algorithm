#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.length();
    string new_str;

    for(int c = 1; c <= s.length(); ++c){
        new_str = "";
        for(int i = 0; i + c < s.length(); ++i)
            if(s.at(i) == s.at(i + c)){
                
            }
        if(new_str.length() < answer)
            answer = new_str.length();
    }

    return answer;
}

int main(int argc, char const *argv[]){
    string s;
    cin >> s;
    cout << solution(s) << "\n";
    return 0;
}
