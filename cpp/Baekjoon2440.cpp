#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    for(; N > 0; --N){
        for(int i = 0; i < N; ++i)
            cout << "*";
        cout << "\n";
    }
    return 0;
}
