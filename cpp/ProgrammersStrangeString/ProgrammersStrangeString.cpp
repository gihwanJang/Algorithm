#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    for(int i = 0, cnt = 0; i < s.length(); ++i, ++cnt){
        if(s[i] == ' ') cnt = -1;
        else{
            if(cnt & 1){
                if(s[i] < 97) s[i] += 32;
            } else{
                if(s[i] > 96) s[i] -= 32;
            }
        }
    }
    return s;
}

int main(int argc, char const *argv[]){
    cout << solution("try hello world") << "\n";
    return 0;
}
