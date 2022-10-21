#include <iostream>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    while(true){
        getline(cin, s);
        if(s == "") break;
        cout << s << "\n";
    }
    return 0;
}
