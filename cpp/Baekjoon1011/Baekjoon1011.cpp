#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--){
        int x, y, d, max;
        cin >> x >> y;

        d = y - x;
        max = (int)sqrt(d);

        if(max == sqrt(d))
            cout << max * 2 - 1 << "\n";
        else if(d <= max * max + max)
            cout << max * 2 << "\n";
        else
            cout << max * 2 + 1 << "\n";
    }
    
    return 0;
}
