#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double L;
    cin >> L;

    cout << fixed;
    cout.precision(10);
    cout << sqrt(3) * pow(L,2) / 4 << "\n";
    return 0;
}
