#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, X, ans = -1;
    cin >> N >> X;

    vector<int> T(N);
    for(int i = 0; i < N; ++i)
        cin >> T[i];
    
    for(int i = 0; X <= T[i]; i = (i+1)%T.size(), ++X)
        ans = i;

    cout << ans + 2 << "\n";
    return 0;
}
