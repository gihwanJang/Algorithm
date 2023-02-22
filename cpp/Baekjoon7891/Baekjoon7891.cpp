#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    long long a, b;
    
    cin >> T;
    while(T--){
        cin >> a >> b;

        cout << a + b << "\n";
    }
    return 0;
}
