#include <iostream>

using namespace std;

bool polyomino(string&s){
    int i = 0;

    while(i < s.size()){
        int cnt = 0;
        while(cnt < 4 && s[i+cnt] != '.' && i+cnt < s.size()){
            ++cnt;
        }

        if(cnt == 0)    
            ++i;
        else if(cnt % 2 == 1)
            return false;
        else if(cnt == 2){
            for(int j = 0; j < cnt; ++j)
                s[i + j] = 'B';
            i += cnt;
        }
        else{
            for(int j = 0; j < cnt; ++j)
                s[i + j] = 'A';
            i += cnt;
        }
    }
    return true;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << (polyomino(s) ? s : "-1") << "\n";
    return 0;
}
