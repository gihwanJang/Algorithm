#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int cnt = 0;
    string s = "";

    int n;
    cin >> n;

    vector<int> nums(n);
    for (int i = 0; i < n; ++i) {
        cin >> nums[i];
    }

    for (int i = 0; i < n; ++i) {
        int min = i;
        for (int j = i+1; j < n; ++j) {
            if (nums[min] > nums[j]) {
                min = j;
            }
        }

        if (i != min) {
            s.append(to_string(i+1));
            s.push_back(' ');
            s.append(to_string(min+1));
            s.push_back('\n');
            ++cnt;
            reverse(nums.begin() + i, nums.begin() + min + 1);
        }
    }

    cout << cnt << "\n";
    cout << s;
    return 0;
}