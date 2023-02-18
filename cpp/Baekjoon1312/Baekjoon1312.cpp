#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b, n, res;
    cin >> a >> b >> n;

    if(a % b == 0){
        cout << 0 << "\n";
        return 0;
    }

    if(a > b) a = a % b;

    for(int i = 0; i < n; ++i){
        a *= 10;
        res = int(a/b);
        a = a % b;
    }
    cout << res << "\n";
    
    return 0;
}
