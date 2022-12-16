#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    while(N--){
        string s;
        cin >> s;
        cout << s[0] << s[s.length() - 1] << "\n";
    }
    return 0;
}
