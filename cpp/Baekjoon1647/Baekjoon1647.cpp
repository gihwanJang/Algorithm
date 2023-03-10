#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int find(vector<int>&parents, int h){
    if(parents[h] == h) return h;
    return parents[h] = find(parents, parents[h]);
}

void union_set(vector<int>&parents, int h1, int h2){
    int r1 = find(parents, h1);
    int r2 = find(parents, h2);
    parents[r1] = r2;
}

int city_division(vector<vector<int>>&roads, int n){
    int cost = 0, cnt = 2;

    vector<int> parents(n+1);
    for(int i = 1; i <= n; ++i)
        parents[i] = i;

    sort(roads.begin(), roads.end());

    for(int i = 0; cnt < n; ++i){
        if(find(parents, roads[i][1]) == find(parents, roads[i][2]))
            continue;

        ++cnt;
        cost += roads[i][0];
        union_set(parents, roads[i][1], roads[i][2]);
    }

    return cost;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m; 
    cin >> n >> m;

    vector<vector<int>> roads(m, vector<int>(3));
    for(int i = 0; i < m; ++i)
        cin >> roads[i][1] >> roads[i][2] >> roads[i][0];

    cout << city_division(roads, n) << "\n";
    return 0;
}
