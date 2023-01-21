#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, ans = 0;
    cin >> n;
    for(int i = 1; i <= n; ++i)
        for(; i > 0; i /= 10)
            ans = (ans % 1234567 + 1) % 1234567;

    cout << ans << '\n';
    return 0;
}
