#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int idx;
    string s;
    cin >> s >> idx;

    cout << s[idx - 1] << "\n";
    return 0;
}
