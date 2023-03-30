#include <algorithm>
#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

int remote(vector<bool>&nums, int N){
    int res = abs(N-100);
    
    pair<int,int> curr;
    pair<int,int> lower = {0,999999};
    pair<int,int> higher = {1234567891,999999};
    
    vector<bool> visited(N*10+10);
    queue<pair<int,int>> que;
    que.push({0,0});

    while(!que.empty()){
        curr = que.front();
        que.pop();

        for(int i = 0; i < 10; ++i)
            if(nums[i] && curr.first <= N && !visited[curr.first*10 + i]){
                que.push({curr.first*10 + i, curr.second+1});
                visited[curr.first*10 + i] = true;
            }
        
        if(curr.first <= N && curr.second)
            lower = curr;
        if(curr.first >= N && curr.second)
            higher = min(higher, curr);
    }

    res = min(res, lower.second + abs(N-lower.first));
    res = min(res, higher.second + abs(N-higher.first));
    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, k;
    cin >> N >> M;

    vector<bool> nums(10, true);
    while(M--){
        cin >> k;
        nums[k] = false;
    }

    cout << remote(nums, N) << "\n";
    return 0;
}
