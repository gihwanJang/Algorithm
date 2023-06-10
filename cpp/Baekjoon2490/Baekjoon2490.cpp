#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for(int i = 0; i < 3; ++i){
        int d, cnt = 0;

        for(int j = 0; j < 4; ++j){
            cin >> d;
            cnt += d;
        }

        if(cnt == 4)
            cout << "E" << "\n";
        else if(cnt == 3)
            cout << "A" << "\n";
        else if(cnt == 2)
            cout << "B" << "\n";
        else if(cnt == 1)
            cout << "C" << "\n";
        else
            cout << "D" << "\n";
    }
    return 0;
}
