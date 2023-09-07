#include <iostream>
#include <vector>

using namespace std;

vector<int> getDP(vector<int>&nums, vector<int>&nums_idx, int n)
{
    int l, r, mid;
    vector<int> DP;

    for(int i = 0; i < n; ++i)
    {
        if(DP.size() == 0 || nums[i] > DP.back())
        {
            DP.push_back(nums[i]);
            nums_idx[i] = DP.size() - 1;
        }
        else
        {
            l = 0;
            r = DP.size()-1;
            
            while (l < r)
            {
                mid = (l + r) / 2;
                
                if (DP[mid] >= nums[i]) r = mid;
                else l = mid + 1;
            }

            DP[l] = nums[i];
            nums_idx[i] = l;
        }
    }

    return DP;
}

vector<int> getLIS(vector<int>&nums, int n)
{
    
    vector<int> LIS;
    vector<int> nums_idx(n);
    vector<int> DP = getDP(nums, nums_idx, n);
    int idx = DP.size() - 1;

    for (int i = n-1; i >= 0; --i)
        if (nums_idx[i] == idx)
        {
            --idx;
            LIS.push_back(nums[i]);
        }

    return LIS;
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n; 
    cin >> n; 

    vector<int> nums(n);
    for (int i = 0; i < n; ++i)
        cin >> nums[i];

    vector<int> LIS = getLIS(nums, n);
    cout << LIS.size() << "\n";
    for(int i = LIS.size()-1; i >= 0; --i)
        cout << LIS[i] << " ";
    return 0;
}
