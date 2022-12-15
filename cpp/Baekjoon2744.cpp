#include <iostream>

using namespace std;

string convertChar(string s){
    for(int i = 0; i < s.length(); ++i){
        if('a' <= s[i] && s[i] <= 'z')
            s[i] -= 32;
        else
            s[i] += 32;
    }
    return s;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << convertChar(s) << "\n";
    return 0;
}
