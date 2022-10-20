#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int answer = 0;
    string row;

    for(int r = 0; r < 8; ++r){
        cin >> row;
        for(int c = 0; c < 8; ++c)
            if(row[c] == 'F'){
                if(!(r & 1) && !(c & 1)) ++answer; 
                if((r & 1) && (c & 1)) ++answer;
            }
    }

    cout << answer << "\n";
    return 0;
}
