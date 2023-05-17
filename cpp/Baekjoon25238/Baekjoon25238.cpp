#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double n, m;
    cin >> n >> m;

    cout << !(n - n * m / 100 >= 100) << "\n";
    return 0;
}
