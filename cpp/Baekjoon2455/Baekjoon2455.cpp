#include <algorithm>
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int ans = 0;
    int total = 0;
    int in;
    int out;

    for(int i = 0; i < 4; ++i){
        cin >> out >> in;
        total += in - out;
        ans = max(ans, total);
    }

    cout << ans << "\n";
    return 0;
}
