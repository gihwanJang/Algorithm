#include <string>
#include <iostream>
using namespace std;

bool solution(string s){
    int ans = 0;
    for(int i = 0; i < s.length(); ++i){
        if(s[i] == 'p' || s[i] == 'P') ++ans;
        if(s[i] == 'y' || s[i] == 'Y') --ans;
    }
    return ans == 0;
}

int main(int argc, char const *argv[]){
    string s = "Pyy";
    cout << solution(s) << "\n";
    return 0;
}
