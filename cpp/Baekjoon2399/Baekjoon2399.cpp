#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    long ans = 0;
    cin >> n;

    vector<long> nums(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];
    
    for(int i = 0; i < n; ++i)
        for(int j = 0; j < n; ++j)
            ans += abs(nums[i] - nums[j]);

    cout << ans << "\n";
    return 0;
}
