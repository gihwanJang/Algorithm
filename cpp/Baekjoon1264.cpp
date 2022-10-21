#include <iostream>

using namespace std;

bool check(char c){
    if(c == 65 || c == 69 || c == 73 || c == 79 || c == 85)
        return true;
    if(c == 97 || c == 101 || c == 105 || c == 111 || c == 117)
        return true;
    return false;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    while(true){
        getline(cin, s);
        if(s == "#") break;

        int cnt = 0;
        for(int i = 0; i < s.length(); ++i)
            if(check(s[i])) ++cnt;

        cout << cnt << "\n";
    }
    return 0;
}
