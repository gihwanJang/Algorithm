#include <iostream>
#include <vector>
#include <cmath>

#define INF (1234567891)

using namespace std;

int calculateDistance(vector<vector<int>>&distance, vector<bool>&select){
    int total_distance = 0;

    for(int r = 0; r < distance.size(); ++r){
        int home_min = INF;

        for(int c = 0; c < distance[0].size(); ++c)
            if(select[c])
                home_min = min(home_min,distance[r][c]);

        total_distance += home_min;
    }

    return total_distance;
}

int chickenDelivery(vector<vector<int>>&distance, vector<bool>&select, int s, int m, int depth){
    if(m == depth)
        return calculateDistance(distance, select);

    int res = INF;

    for(int i = s; i < select.size(); ++i){
        select[i] = true;
        res = min(res,chickenDelivery(distance, select, i+1, m, depth+1));
        select[i] = false;
    }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, val;
    cin >> n >> m;

    vector<pair<int,int>> store;
    vector<pair<int,int>> home;
    for(int r = 1; r <= n; ++r){
        for(int c = 1; c <= n; ++c){
            cin >> val;

            if(val == 2)
                store.push_back({r,c});
            else if(val == 1)
                home.push_back({r,c});
        }
    }

    vector<bool> select(store.size());
    vector<vector<int>> distance(home.size(), vector<int>(store.size()));
    for(int r = 0; r < home.size(); ++r)
        for(int c = 0; c < store.size(); ++c)
            distance[r][c] = abs(home[r].first - store[c].first) + abs(home[r].second - store[c].second);

    cout << chickenDelivery(distance, select, 0, m, 0) << "\n";
    return 0;
}
