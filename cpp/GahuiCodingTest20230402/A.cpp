#include <iostream>

#define ES 21
#define STAIR 17

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    int n, ans = 0;

    for(int i = 0; i < 4; ++i){
        cin >> s >> n;

        ans += n * (s == "Es" ? ES : STAIR);
    }

    cout << ans << "\n";
    return 0;
}
