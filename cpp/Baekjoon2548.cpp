#include <iostream>
#include <cmath>
#include <utility>
#include <vector>
#include <unordered_set>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    pair<int, int> ans = make_pair(0,2000000000);
    unordered_set<int> set(10000);
    vector<int> arr(N);
    for(int i = 0; i < N; ++i)
        cin >> arr[i];

    for(int i = 0; i < N; ++i)
        if(!set.count(arr[i])){
            int sum = 0;
            set.insert(arr[i]);
            for(int j = 0; j < N; ++j)
                sum += abs(arr[i] - arr[j]);
            if(ans.second > sum || (ans.second == sum && ans.first > arr[i]))
                ans = make_pair(arr[i], sum);
        }
    
    cout << ans.first << "\n";
    return 0;
}
