#include <iostream>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s, print_s;

    cin >> s;
    for(int i = 0; i < s.length(); ++i){
        print_s += s[i];
        if(print_s.length() == 10 || i == s.length() - 1){
            cout << print_s << "\n";
            print_s.clear();
        }
    }
    return 0;
}
