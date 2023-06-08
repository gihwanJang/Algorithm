#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, a, b;
    cin >> n >> a >> b;

    if(b < a)
        cout << "Subway" << "\n";
    else if(b > a)
        cout << "Bus" << "\n";
    else
        cout << "Anything" << "\n";
    return 0;
}
