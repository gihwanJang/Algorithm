#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

int solution(vector<int> nums){
    unordered_set<int> set(nums.size());
    for(int i = 0; i < nums.size(); ++i) set.insert(nums[i]);
    return set.size() < nums.size() / 2 ? set.size() : nums.size() / 2;
}

int main(int argc, char const *argv[]){
    vector<int> nums = {3,3,3,2,2,4};
    cout << solution(nums) << "\n";
    return 0;
}
