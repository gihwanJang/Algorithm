#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void permutation(vector<int>&arr, vector<int>&res, int m, int s){
    if(res.size() == m){
        for(int i = 0; i < m; ++i)
            cout << res[i] << " ";
        cout << "\n";

        return;
    }

    for(int i = s; i < arr.size(); ++i){
        res.push_back(arr[i]);
        permutation(arr, res, m, i);
        res.pop_back();
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> res;
    vector<int> arr(n);
    for(int i = 0; i < n; ++i)
        cin >> arr[i];

    sort(arr.begin(), arr.end());

    permutation(arr, res, m, 0);
    return 0;
}
