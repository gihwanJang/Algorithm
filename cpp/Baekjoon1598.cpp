#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b;
    cin >> a >> b;

    --a;
    --b;
    
    cout << abs(b / 4 - a / 4) + abs(b % 4 - a % 4) << "\n";
    return 0;
}
