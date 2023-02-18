#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    string s;

    cin >> N;

    while(N --){
        cin >> s;
        cout << (s.length() > 5 && s.length() < 10 ? "yes" : "no") << "\n";
    }
    return 0;
}
