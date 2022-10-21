#include <iostream>
#include <string>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;

    while(true){
        int prev = -1, next;
        cin >> N;
        if(N == 0) break;

        for(int i = 0; i < N; ++i, prev = next){
            cin >> next;
            if(prev == next) continue;
            cout << next << " ";
        }
        cout << "$" << "\n";
    }
    return 0;
}
