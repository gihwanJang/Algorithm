#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;

    cout << (t/5) + (t%5>0) << "\n";
    return 0;
}
