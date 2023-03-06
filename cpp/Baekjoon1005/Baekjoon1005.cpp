#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int calculateTime(vector<int>&building, vector<int>&inDegree, vector<vector<bool>>&rules, int target){
    vector<int> time(building.size());
    for(int i = 0; i < building.size(); ++i)
        time[i] = building[i];

    queue<int> que;
    for(int i = 0; i < building.size(); ++i)
        if(inDegree[i] == 0)
            que.push(i);

    while(!que.empty()){
        int curr = que.front();
        que.pop();

        for(int i = 0; i < building.size(); ++i)
            if(rules[curr][i]){
                time[i] = max(time[i], time[curr] + building[i]);
                --inDegree[i];
                if(inDegree[i] == 0)
                    que.push(i);
            }
    }

    return time[target];
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, n, k, f, s, target;
    cin >> T;

    while(T--){
        // 건물수, 규칙수 입력
        cin >> n >> k;
        // 건설 시간 입력
        vector<int> building(n);
        for(int i = 0; i < n; ++i)
            cin >> building[i];
        // 진입차수 및 규칙 입력
        vector<int> inDegree(n);
        vector<vector<bool>> rules(n, vector<bool>(n));
        while(k--){
            cin >> f >> s;
            rules[--f][--s] = true;
            ++inDegree[s];
        }
        // 타켓 건물 입력
        cin >> target;
        // 출력
        cout << calculateTime(building, inDegree, rules, target-1) << "\n"; 
    }
    return 0;
}
