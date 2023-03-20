#include <iostream>

using namespace std;

int modular(int a, long b){
    return (a % 1234567 + b % 1234567) % 1234567;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long n, ans = 0, digit = 1;
    cin >> n;

    for(int cnt = 1; n >= digit; ++cnt, digit *= 10)
        ans = modular(ans, cnt * ((n >= digit*10 ? digit*10 : n + 1) -  digit));

    cout << ans << '\n';
    return 0;
}