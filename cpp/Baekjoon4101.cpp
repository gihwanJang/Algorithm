#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int f, s;
    while(true){
        cin >> f >> s;
        if(f == 0 && s == 0)
            break;
        cout << (f > s ? "Yes" : "No") << "\n";
    }
    return 0;
}
