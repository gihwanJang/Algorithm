#include <iostream>
#include <utility>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, answer = -1, table[17] = {0,};
    pair<int,int> schedule[16];

    cin >> n;
    for(int i = 1, f, s; i <= n; ++i){
        cin >> f >> s;
        schedule[i] = make_pair(f, s);
    }

    for(int i = 1; i <= n; ++i){
        table[i] = max(table[i], table[i - 1]);
        table[i + schedule[i].first] = max(table[i + schedule[i].first], table[i] + schedule[i].second);
        answer = max(answer, table[i]);
    }

    cout << max(answer, table[n + 1]) << "\n";
    return 0;
}
