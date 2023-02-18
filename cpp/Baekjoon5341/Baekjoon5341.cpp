#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    while(true){
        cin >> n;
        if(n == 0)break;

        cout << n * (n + 1) / 2 << "\n";
    }
    return 0;
}
