#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    long long ans = 0;
    cin >> n >> k;

    vector<int> nums(n);
    for(int i = 0; i < n; ++i)
        cin >> nums[i];

    vector<pair<int,int>> select(k);
    for(int i = 0; i < k; ++i)
        select[i] = make_pair(nums[i], i);
    sort(select.begin(), select.end());
    for(int l = 1; l < k; ++l)
        ans += abs(select[l - 1].second - select[l].second);

    for(int i = k; i < n; ++i){
        for(int j = 0; j < k; ++j)
            if(select[j].second == i - k)
                select[j] = make_pair(nums[i], i);

        long long sum = 0;
        sort(select.begin(), select.end());
        for(int l = 1; l < k; ++l)
            sum += abs(select[l - 1].second - select[l].second);
        ans = min(ans, sum);
    }

    cout << ans << "\n";
    return 0;
}
