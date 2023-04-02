#include <unordered_map>
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int routing(unordered_map<int,int>&map){
    pair<int,int> curr;
    vector<bool> visited(101);
    queue<pair<int,int>> que;
    que.push({1,0});

    while(!que.empty()){
        curr = que.front();
        que.pop();
        visited[curr.first] = true;

        if(curr.first == 100)
            return curr.second;

        for(int d = 1; d < 7; ++d)
            if(curr.first + d < 101 && !visited[curr.first + d]){
                if(!map.count(curr.first+d))
                    que.push({curr.first+d, curr.second+1});
                else
                    que.push({map.at(curr.first+d), curr.second+1});
            }
    }
    return -1;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n >> m;

    unordered_map<int,int> map;
    for(int i = 0; i < n+m; ++i){
        cin >> s >> e;
        map.insert({s, e});
    }

    cout << routing(map) << "\n";
    return 0;
}
