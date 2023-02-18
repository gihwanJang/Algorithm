#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

bool findHundred(vector<int>&nums, unordered_set<int>&set, int sum){
    if(set.size() == 7 && sum == 100) return true;

    for(int i = 0; i < 9; ++i){
        if(set.count(i))
            continue;
        set.insert(i);
        if(findHundred(nums, set, sum + nums[i]))
            return true;
        set.erase(i);
    }

    return false;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_set<int> set(7);
    vector<int> nums(9);
    for(int i = 0; i < 9; ++i)
        cin >> nums[i];

    findHundred(nums, set, 0);

    vector<int> ans;
    for(int i : set)
        ans.push_back(nums[i]);
    sort(ans.begin(), ans.end());

    for(int i = 0; i < 7; ++i)
        cout << ans[i] << "\n";
    return 0;
}
