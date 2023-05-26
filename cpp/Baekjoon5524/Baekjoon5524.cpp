#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;

    cin >> n;
    while(n--){
        cin >> s;

        for(int i = 0; i < s.length(); ++i)
            if(s[i] < 97)
                s[i] += 32;

        cout << s << "\n";
    }
    return 0;
}
