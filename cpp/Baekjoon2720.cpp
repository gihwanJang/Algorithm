#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, price, coins[] = {25, 10, 5, 1};
    cin >> N;

    while(N--){
        cin >> price;
        for(int i = 0; i < 4; ++i){
            cout << price / coins[i] << " ";
            price %= coins[i];
        }
        cout << "\n";
    }
    return 0;
}
