#include <algorithm>
#include <iostream>

using namespace std;

string isPattern(string&s) {
    //cout << s << "\n";
    if(s.empty()) return "YES";
    if(s.size() <= 1) return "NO";

    if(s.back() == '0') {
        s.pop_back();
        if(s.back() == '1') {
            s.pop_back();
            return isPattern(s);
        }
        else
            return "NO";
    }
    else {
        int cnt = 0;
        s.pop_back();

        while(!s.empty() && s.back() == '0'){
            ++cnt;
            s.pop_back();
        }

        if(cnt < 2) return "NO";
        else{
            cnt = 0;
            while(!s.empty() && s.back() == '1'){
                s.pop_back();
                ++cnt;
            }

            if(cnt == 0) return "NO";
            if(cnt == 1) return isPattern(s);

            if(s.size() > 1) {
                if(s[s.size()-2] == '0')
                    s.push_back('1');

                return isPattern(s);
            }
        }
    }
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while(T--) {
        string s;
        cin >> s;
        reverse(s.begin(), s.end());
        cout << isPattern(s) << "\n";
    }
    return 0;
}
