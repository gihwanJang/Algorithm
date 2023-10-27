#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    for(int i = 0; i < N; ++i){
        for(int j = 0; j <= i; ++j)
            cout << "*";
        cout << "\n";
    }
    for(int i = N-2; i >= 0; --i){
        for(int j = 0; j <= i; ++j)
            cout << "*";
        cout << "\n";
    }
    return 0;
}
