#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int S, T, ans = 0;
    cin >> S >> T;

    for(int i = 1; i <= T; ++i)
        for(int j = 1; i * j <= T; ++j)
            if(i * j >= S)
                ans += i & 1 ? -1 : 1;

    cout << ans << "\n";
    return 0;
}
