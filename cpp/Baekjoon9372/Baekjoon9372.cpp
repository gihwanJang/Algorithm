#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n, m, u, v;
    cin >> T;

    while(T--){
        cin >> n >> m;

        while(m--)
            cin >> u >> v;
        
        cout << n - 1 << "\n";
    }
    return 0;
}
