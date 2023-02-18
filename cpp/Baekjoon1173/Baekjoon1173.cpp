#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, m, M, T, R, ans = 0, check = -1;
    cin >> N >> m >> M >> T >> R;

    if(m + T > M){
        cout << -1 << "\n";
        return 0;
    }

    for(int n = 0, h = m; n < N; ++ans){
        if(h + T <= M){
            ++n;
            h += T;
        }
        else{
            if(h - R < m)
                h = m;
            else
                h -= R;
        }
    }

    cout << ans << "\n";
    return 0;
}
