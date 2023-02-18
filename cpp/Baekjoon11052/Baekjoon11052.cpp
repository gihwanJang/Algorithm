#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, nums[1001];
    cin >> n;
    for(int i = 1; i <= n; ++i)
        cin >> nums[i];

    vector<int> table(n + 1, 0);
    for(int i = 0; i <= n; ++i)
        for(int j = 1; j + i <= n; ++j)
            table[i + j] = max(table[i + j], table[i] + nums[j]);

    cout << table[n] << "\n";
    return 0;
}
