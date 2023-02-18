#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int calculate(vector<int>&formula){
    int res = 0;

    for(int i = 1; i < formula.size(); ++i)
            res += abs(formula[i - 1] - formula[i]);

    return res;
}

int formulating(vector<int>&nums, vector<int>&formula, vector<bool>&visited){
    if(formula.size() == nums.size())
        return calculate(formula);
    
    int ans = 0;

    for(int i = 0; i < nums.size(); ++i)
        if(!visited[i]){
            visited[i] = true;
            formula.push_back(nums[i]);

            ans = max(ans, formulating(nums, formula, visited));

            visited[i] = false;
            formula.pop_back();
        }

    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> formula;
    vector<int> nums(n);
    vector<bool> visited(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];

    cout << formulating(nums, formula, visited) << "\n";
    return 0;
}