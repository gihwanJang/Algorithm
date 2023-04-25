#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> alpha(26);
    string s;
    cin >> s;

    for(int i = 0; i < s.length(); ++i)
        ++alpha[s[i] - 'a'];
    
    for(int i = 0; i < 26; ++i)
        cout << alpha[i] << " ";
    cout << "\n";
    return 0;
}
