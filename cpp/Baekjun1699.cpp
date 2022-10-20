#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, table[100001];
    cin >> n;

    for(int i = 0; i <= n; ++i) table[i] = i;
    for(int i = 1; i <= n; ++i){
        for(int j = 1; j * j <= i; ++j)
            table[i] = min(table[i], table[i - j * j] + 1); 
    }

    cout << table[n] << "\n";
    return 0;
}
