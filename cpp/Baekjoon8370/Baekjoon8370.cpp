#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k, sum = 0;
    for(int i = 0; i < 2; ++i){
        cin >> n >> k;
        sum += n * k;
    }

    cout << sum << "\n";
    return 0;
}
