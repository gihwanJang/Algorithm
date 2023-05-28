#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int a, b, c, d;
    cin >> a >> b >> c >> d;

    cout << (a+d > b+c ? b+c : a+d) << "\n";
    return 0;
}
