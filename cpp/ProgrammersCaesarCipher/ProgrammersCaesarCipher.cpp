#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    for(int i = 0; i < s.length(); ++i){
        if(s[i] >= 65 && s[i] <= 90){
            s[i] += n;
            if(s[i] > 90) s[i] -= 26;
        }
        else if(s[i] >= 97 && s[i] <= 122){
            if(s[i] + n > 122) s[i] -= 26;
            s[i] += n;
        }
    }
    return s;
}

int main(int argc, char const *argv[]){
    cout << solution("a B z", 25) << "\n";
    return 0;
}
