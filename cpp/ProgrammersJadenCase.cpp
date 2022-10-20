#include <iostream>
#include <string>
#include <vector>

using namespace std;

char upper(char c){
    if(c > 96 && c < 123)
        return c - 32;
    else
        return c;
}

char lowwer(char c){
    if(c > 64 && c < 91)
        return c + 32;
    else
        return c;
}

string solution(string s) {
    s[0] = upper(s[0]);
    for(int i = 1; i < s.length(); ++i){
        if(s[i] == ' '){
            while(s[i] == ' ') ++i;
            s[i] = upper(s[i]);
        }
        else
            s[i] = lowwer(s[i]);
    }
    return s;
}

int main(int argc, char const *argv[]){
    cout << solution("3people unFollowed me") << "\n";
    return 0;
}
