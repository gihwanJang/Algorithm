#include <iostream>

using namespace std;

int main(void) {
    int a, b;

    cin >> a >> b;
    
    for(; b > 0; --b){
        for(int i = 0; i < a; ++i)
            cout << "*";
        cout << "\n";
    }
    return 0;
}