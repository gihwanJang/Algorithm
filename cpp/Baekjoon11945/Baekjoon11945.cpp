#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    string s;
    while(n--){
        cin >> s;

        reverse(s.begin(), s.end());

        cout << s << "\n";
    }
    return 0;
}
