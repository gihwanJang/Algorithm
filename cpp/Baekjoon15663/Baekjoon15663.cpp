#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void combin(vector<int>&arr, vector<int>&res, vector<bool>&visited, int m){
    if(res.size() == m){
        for(int i = 0; i < m; ++i)
            cout << res[i] << " ";
        cout << "\n";

        return;
    }

    int curr = -1;

    for(int i = 0; i < arr.size(); ++i){
        if(curr == arr[i] || visited[i])
            continue;

        curr = arr[i];

        res.push_back(arr[i]);
        visited[i] = true;
        combin(arr, res, visited, m);
        visited[i] = false;
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
    vector<bool> visited(n);
    vector<int> arr(n);
    for(int i = 0; i < n; ++i)
        cin >> arr[i];

    sort(arr.begin(), arr.end());

    combin(arr, res, visited, m);
    return 0;
}
