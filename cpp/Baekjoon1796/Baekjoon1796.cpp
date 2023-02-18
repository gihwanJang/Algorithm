#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int l, p, v, ans;
    
    for(int i = 1; i; ++i){
        cin >> l >> p >> v;

        if(l == 0 && p == 0 && v == 0)
            break;

        ans = v / p * l;
        ans += (v % p <= l ? v % p : l);

        cout << "Case " << i << ": " << ans << "\n";
    }
    return 0;
}
