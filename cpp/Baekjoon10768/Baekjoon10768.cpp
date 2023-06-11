#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, d;
    cin >> m >> d;

    if(m > 2)
        cout << "After\n";
    else if(m == 2){
        if(d > 18)
            cout << "After\n";
        else if(d == 18)
            cout << "Special\n";
        else
            cout << "Before\n";
    }
    else
        cout << "Before\n";
    return 0;
}
