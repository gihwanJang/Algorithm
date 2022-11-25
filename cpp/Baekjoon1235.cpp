#include <iostream>
#include <vector>
#include <cmath>
#include <unordered_set>

using namespace std;

int count_bit(int N){
    int i = 1;

    while(pow(10,i) < N)
        ++i;

    return i;
}

bool checkDivisions(vector<string>&nums, int min_count){
    unordered_set<string> set;

    set.insert(nums[0].substr(nums[0].length() - min_count, min_count));
    for(int i = 1; i < nums.size(); ++i){
        if(set.count(nums[i].substr(nums[i].length() - min_count, min_count)))
            return false;
        else
            set.insert(nums[i].substr(nums[i].length() - min_count, min_count));
    }

    return true;
}

int getMinimumNumberOfDivisions(vector<string>&nums){
    int min_count = count_bit(nums.size());

    while(!checkDivisions(nums, min_count))
        ++min_count;
    
    return min_count;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<string> nums(N);
    for(int i = 0; i < N; ++i)
        cin >> nums[i];

    cout << getMinimumNumberOfDivisions(nums) << "\n";

    return 0;
}
