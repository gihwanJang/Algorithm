#include <iostream>
#include <vector>

using namespace std;

int calculateTime(vector<int>&building, vector<vector<int>>&rules, int target){
    int time = building[target];

    vector<bool> visited(building.size());
    for(int i = 0; i < rules[target].size(); ++i){
        
    }

    return time;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n, k, p, c, target;
    cin >> T;

    while(T--) {
        cin >> n >> k;

        vector<int> building(n+1);
        for(int i = 1; i <= n; ++i)
            cin >> building[i];
        
        vector<vector<int>> rules(n+1);
        while(k--){
            cin >> p >> c;
            rules[p].push_back(c);
        }

        cin >> target;

        cout << calculateTime(building, rules, target) << "\n";
    }    
    return 0;
}
