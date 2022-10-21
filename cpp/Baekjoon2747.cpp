#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, table[45];
    cin >> N;

    table[0] = table[1] = 1;

    for(int i = 2; i < N; ++i)
        table[i] = table[i - 1] + table[i - 2];

    cout << table[N - 1] << "\n";
    return 0;
}
