#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, ans = 0;
    cin >> N >> M;

    vector<int> table(N + 1);
    for(int i = 1; i <= N; ++i){
        cin >> table[i];
        table[i] += table[i - 1];
    }

    for(int i = 0; i < N; ++i)
        for(int j = i + 1; j <= N; ++j)
            if(table[j] - table[i] == M)
                ++ans;
    
    cout << ans << "\n";
    return 0;
}
