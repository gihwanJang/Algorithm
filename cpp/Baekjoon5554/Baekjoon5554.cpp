#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int time, total = 0;
    for(int i = 0; i  < 4; ++i){
        cin >> time;
        total += time;
    }

    cout << total / 60 << "\n";
    cout << total % 60 << "\n";
    return 0;
}
