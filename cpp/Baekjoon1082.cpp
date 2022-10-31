#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

string cmp(string num1, string num2){
    if(num1.size() != num2.size())
        return num1.size() > num2.size() ? num1 : num2;
    else
        return max(num1, num2);
}

string findBigNum(vector<int>&nums, int M, string n){
    if(M == 0) return n;

    string s = n;

    for(int i = s == "" ? 1 : 0; i < nums.size(); ++i)
        if(M >= nums[i]){
            s += to_string(i);
            n = cmp(n, findBigNum(nums, M - nums[i], s));
            s.pop_back();
        }

    return n;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> nums(N);
    for(int i = 0; i < N; ++i)
        cin >> nums[i];

    int M;
    cin >> M;

    string ans = findBigNum(nums, M, "");

    cout << (ans == "" ? "0" : ans) << "\n";
    return 0;
}
