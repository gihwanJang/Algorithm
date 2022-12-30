#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;
    
    vector<vector<int>> table(k + 1, vector<int>(n + 1));

    for(int i=0;i<=n;i++)
        table[1][i] = 1;

    for(int i=1;i<=k;i++)
        for(int j=0;j<=n;j++)
            for(int l=0;l<=j;l++)
                table[i][j] = (table[i][j] % 1000000000 + table[i-1][j-l] % 1000000000) % 1000000000;

    cout << table[k][n] << "\n";
    return 0;
}
