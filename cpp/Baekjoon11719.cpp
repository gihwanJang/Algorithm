#include <iostream>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    while(getline(cin, s))
        cout << s << "\n";
    return 0;
}
