#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, longestLength = 0;
    cin >> N;

    vector<pair<int,int>> table(N);
    for(int i = 0; i < N; ++i){
        cin >> table[i].first;
        for(int j = 0; j < i; ++j)
            if(table[i].first > table[j].first)
                table[i].second = max(table[i].second, table[j].second + 1);
        longestLength = max(longestLength, table[i].second);
    }
        
    cout << longestLength + 1 << "\n";
    return 0;
}
