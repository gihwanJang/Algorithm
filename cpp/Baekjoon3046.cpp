#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int r1, s;
    cin >> r1 >> s;

    cout << 2*s - r1 << "\n";
    return 0;
}
