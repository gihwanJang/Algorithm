#include <iostream>
#include <vector>

using namespace std;

bool isPalindrome(vector<int>&nums, int s, int e){
    for(; s < e; ++s, --e)
        if(nums[s] != nums[e])
            return false;

    return true;
}

void findPalindrome(vector<int>&nums, vector<vector<bool>>&table){
    int c_r, c_c;

    for(int r = 0; r < nums.size(); ++r)
        for(int c = r; c < nums.size(); ++c)
            if(!table[r][c])
                if(isPalindrome(nums, r, c))
                    for(c_r = r, c_c =c; c_r <= c_c; ++c_r, --c_c)    
                        table[c_r][c_c] = true;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, s, e;
    cin >> n;

    vector<int> nums(n);
    for(int i = 0;i < n; ++i)
        cin >> nums[i];
    
    vector<vector<bool>> table(n, vector<bool>(n));
    findPalindrome(nums, table);

    cin >> m;
    while(m--){
        cin >> s >> e;
        cout << (table[s-1][e-1] ? 1 : 0) << "\n";
    }
    return 0;
}
