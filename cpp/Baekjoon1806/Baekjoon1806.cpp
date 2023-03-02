#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int findSubSum(vector<int>&nums, int s){
    int lo = 0;
	int hi = 0;
	int sum = nums[0];
	int len = nums.size() + 1;

    while (lo <= hi && hi < nums.size()) {
		if (sum < s) {
			sum += nums[++hi];
		}
		else {
			len = min(len, hi - lo + 1);
			sum -= nums[lo++];
		}
	}

    return len == nums.size() + 1 ? 0 : len;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, s;
    cin >> n >> s;

    vector<int> nums(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];

    cout << findSubSum(nums, s) << "\n";
    return 0;
}