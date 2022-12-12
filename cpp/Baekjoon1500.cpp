#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long ans = 1;
    int S, K;
    cin >> S >> K;

    for(; K > 0; --K){
        ans *= S / K;
        S -= (S / K);
    }

    cout << ans << "\n";
    return 0;
}
