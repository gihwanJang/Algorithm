#include <algorithm>
#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long a,b,c;
    cin >> a >> b >> c;

    cout << max(int(double(a*b)/c), int(double(a)/b*c));
    return 0;
}
