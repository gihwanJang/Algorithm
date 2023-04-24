#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << (n - n * 22 / 100) << "\n";
    cout << (n - n * 22 / 500) << "\n";
    return 0;
}
