#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin. tie(NULL);
    cout.tie(NULL);

    int sum = 0;

    vector<int> nums(5);
    for(int i = 0; i < 5; sum += nums[i], ++i)
        cin >> nums[i];

    sort(nums.begin(), nums.end());
    
    cout << sum / 5 << "\n";
    cout << nums[2] << "\n";
    return 0;
}
