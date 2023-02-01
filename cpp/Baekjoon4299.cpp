#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum, sub;
    double x, y;
    cin >> sum >> sub;

    y = (sum - sub) / 2;
    x = (sum + sub) / 2;

    if(x < 0 || y < 0 || x+y != sum || abs(x-y) != sub){
        cout << -1 << "\n";
        return 0;
    }

    cout << (y > x ? y : x) << " " << (y > x ? x : y) << "\n";
    return 0;
}
