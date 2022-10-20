#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    while(true){
        string s1, s2;
        cin >> s1;

        if(s1 == "0") break;

        s2 = s1;
        reverse(s1.begin(), s1.end());

        cout << (s1 == s2 ? "yes" : "no") << "\n";
    }
    return 0;
}
