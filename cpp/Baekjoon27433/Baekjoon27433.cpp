#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long res = 1;
    int n;
    cin >> n;

    for(int i = 1; i <= n; ++i)
        res *= i;

    cout << res << "\n";
    return 0;
}
