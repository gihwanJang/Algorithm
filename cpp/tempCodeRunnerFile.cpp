#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;

bool cmp(pair<int,int> a, pair<int,int> b){
    return a.second < b.second;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int,int>> nums(N);
    vector<int> table(N);

    for(int i = 0; i < N; ++i){
        nums[i].first = i;
        cin >> nums[i].second;
    }

    if(N == 1){
        cout << 0 << "\n";
        return 0;
    }

    sort(nums.begin(), nums.end(), cmp);

    for(int i = 1; i < N; ++i)
        for(int j = i - 1; j > -1; --j)
            if(nums[i].second % nums[j].second == 0){
                table[nums[i].first] = table[nums[j].first] + 1;
                break;
            }

    for(int i = N - 1; i  > 0; --i)
        if(nums[i].second == nums[i - 1].second)
            table[nums[i - 1].first] = table[nums[i].first];

    for(int i = 0; i < N; ++i)
        cout << table[i] << "\n";
    
    return 0;
}