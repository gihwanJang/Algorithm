#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int z_cnt = 0, o_cnt = 0;
    char prev = ' ';

    string s;
    cin >> s;

    for(int i = 0; i < s.length(); ++i){
        if(prev == s[i]) continue;
        else{
            if(s[i] == '0') ++z_cnt;
            else ++o_cnt;
            prev = s[i];
        }
    }
    
    cout << (z_cnt > o_cnt ? o_cnt : z_cnt) << "\n";
    return 0;
}
