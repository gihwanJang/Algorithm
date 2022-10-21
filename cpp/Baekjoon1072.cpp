#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double X, Y, Z;
    cin >> X >> Y;
    Z = trunc(X / Y * 100);

    return 0;
}
