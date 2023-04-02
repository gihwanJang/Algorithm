#include <iostream>

using namespace std;

int counting(int n, string s){
    int res = 0, sub = 0;

    for(int i = 0; i < s.length()-2; ++i, sub = 0)
        if(s[i] != 'O')
            for(; s[i + 1] == 'O' && s[i + 2] == 'I'; i += 2)
                if (++sub == n) {
                    --sub;
                    ++res;
                }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    string s;
    cin >> n >> m >> s;

    cout << counting(n, s) << "\n";
    return 0;
}
