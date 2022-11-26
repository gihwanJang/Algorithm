#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, ans = 5;
    cin >> N;

    for(int i = 2; i <= N; ++i)
        ans = (ans % 45678 + ((i * 5) - (2 * i - 1)) % 45678) % 45678;

    cout << ans << "\n";
    return 0;
}
