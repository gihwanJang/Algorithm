#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double a, b;
    cin >> a >> b;

    cout << b-a << " " << b << "\n";
    return 0;
}
