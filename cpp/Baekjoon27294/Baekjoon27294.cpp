#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int t, e;
    cin >> t >> e;

    if(e || t < 12 || t > 16)
        cout << 280 << "\n";
    else
        cout << 320 << "\n";
    return 0;
}
