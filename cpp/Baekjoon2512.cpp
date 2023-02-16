#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum = 0;
    int total;
    int n;
    cin >> n;

    vector<int> prices(n);
    for(int i = 0; i < n; ++i){
        cin >> prices[i];
        sum += prices[i];
    }
    sort(prices.begin(), prices.end(), greater<>());
    cin >> total;

    if(sum <= total){
        cout << prices[0] << "\n";
        return 0;
    }

    for(; prices.back() <= total / n; --n){
        sum -= prices.back();
        total -= prices.back();
        prices.pop_back();
    }

    cout << total / n << "\n";
    return 0;
}
