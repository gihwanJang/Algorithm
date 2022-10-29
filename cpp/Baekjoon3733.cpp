#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, S;
    while(cin >> N >> S)
        cout << S/ (N + 1) << "\n";
    return 0;
}
