#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int G, curr = 1, remember = 1;
    bool flag = false;
    cin >> G;

    while(curr - remember != 1 || curr * curr - remember * remember <= G){
        if(curr * curr - remember * remember == G){
            flag = true;
            cout << curr << "\n";
        }
        if(curr * curr - remember * remember > G)
            ++remember;
        else
            ++curr;
    }

    if(!flag) cout << -1 << "\n";
    return 0;
}
