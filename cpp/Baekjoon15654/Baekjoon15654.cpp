#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void print(vector<int>&nums, vector<bool>&visited, vector<int>&res, int m){
    if(res.size() == m){
        for(int i = 0; i < m; ++i)
            cout << res[i] << " ";
        cout << "\n";
        return;
    }

    for(int i = 0; i < nums.size(); ++i)
        if(!visited[i]){
            visited[i] = true;
            res.push_back(nums[i]);
            print(nums, visited, res, m);
            res.pop_back();
            visited[i] = false;
        }
}

void combine(vector<int>&nums, int m){
    vector<bool> visited(nums.size());
    vector<int> res;

    sort(nums.begin(), nums.end());

    print(nums, visited, res, m);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> nums(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];

    combine(nums, m);
    return 0;
}
