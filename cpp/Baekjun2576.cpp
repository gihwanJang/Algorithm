#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num, minOdd = 100, sum = 0;

    for(int i = 0; i < 7; ++i){
        cin >> num;
        if(num & 1){
            sum += num;
            minOdd = min(minOdd, num);
        }
    }

    if(sum == 0) cout << -1 <<"\n";
    else cout << sum << "\n" << minOdd << "\n";
    return 0;
}
