#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> nums(n+1);
    for(int i = 1; i <= n; ++i)
        nums[i] = i;

    for(int i = 0, s, e; i < m; ++i)
    {
        cin >> s >> e;
        reverse(nums.begin()+s, nums.begin()+e+1);
    }

    for(int i = 1; i <= n; ++i)
        cout << nums[i] << " ";
    return 0;
}
