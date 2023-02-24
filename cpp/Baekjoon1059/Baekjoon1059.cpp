#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int binarySearch(vector<int>&set, int n){
    int lo = 0, hi = set.size(), mid;

    while(lo < hi){
        mid = (lo + hi) / 2;

        if(set[mid] == n)
            return mid;
        else if(set[mid] < n)
            lo = mid + 1;
        else
            hi = mid;
    }

    return lo-1;
}

int countingSection(vector<int>&set, int n){
    sort(set.begin(), set.end());
    int idx = binarySearch(set, n);

    if(!(set[idx] == n) && idx != set.size()-1)
        return (n - (set[idx]+1)) * (set[idx+1] - n) + (set[idx+1] - n - 1);
    return 0;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int l, n;
    cin >> l;

    vector<int> set(l);
    for(int i = 0; i < l; ++i)
        cin >> set[i];

    cin >> n;

    cout << countingSection(set, n) << "\n";
    return 0;
}