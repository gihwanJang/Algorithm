#include <iostream>
#include <vector>

using namespace std;

void makeNumberOfKing(vector<vector<long>>&stores, vector<int>&king_store, vector<int>&king_empoloy, int n, int m) {
    pair<int,int> max;

    for(int i = 0; i < m; ++i){
        max = {0, stores[i][0]};

        for(int j = 1; j < n; ++j)
            if(max.second < stores[i][j])
                max = {j, stores[i][j]};
        
        king_store[i] = max.first;
        ++king_empoloy[max.first];
    }
}

int getNumberOfKing(vector<vector<long>>&stores, vector<int>&king_store, vector<int>&king_empoloy, int n, int k, int s, int e) {
    int cnt = 0;
    
    if(stores[s][king_store[s]] < stores[s][e]) {
        --king_empoloy[king_store[s]];
        king_store[s] = e;
        ++king_empoloy[e];
    }

    for(int i = 0; i < n; ++i)
        if(king_empoloy[i] == k)
            ++cnt;

    return cnt;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, k, e, s, t;
    long c;
    cin >> n >> m >> k;

    vector<vector<long>> stores(m, vector<long>(n));
    for(int i = 0; i < n; ++i)
        for(int j = 0; j < k; ++j){
            cin >> s >> c;
            stores[s-1][i] += c;
        }

    vector<int> king_empoloy(n);
    vector<int> king_store(m);
    makeNumberOfKing(stores, king_store, king_empoloy, n, m);
    
    cin >> t;
    while(t--) {
        cin >> e >> s >> c;

        stores[s-1][e-1] += c;
        /*
        cout << "<store_total price>\n";
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j)
                cout << stores[i][j] << ",";
            cout << "\n";
        }
        */
        cout << getNumberOfKing(stores, king_store, king_empoloy, n, k, s-1, e-1) << "\n";
        /*
        cout << "<king_store>\n";
        for(int i = 0; i < m; ++i)
            cout << king_store[i] << ",";
        cout << "\n";

        cout << "<king_employ>\n";
        for(int i = 0; i < n; ++i)
            cout << king_empoloy[i] << ",";
        cout << "\n";
        */
    }
    return 0;
}
