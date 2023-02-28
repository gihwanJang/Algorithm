#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void binarySearch(vector<int> &liquid, int i, int&mix, int&ans1, int&ans2){
    int lo = i+1, hi = liquid.size()-1, mid, sum;

    while(lo <= hi){
        mid = (lo + hi) / 2;
        sum = abs(liquid[i] + liquid[mid]);

        if(sum < mix){
            mix = sum;
            ans1 = liquid[i];
            ans2 = liquid[mid];
        }

        if (liquid[mid] == -liquid[i])
            break;
        else if (liquid[mid] < -liquid[i])
            lo = mid+1; 
        else
            hi = mid-1;
    }
}

void solution(vector<int>&liquid, int&ans1, int&ans2){
    sort(liquid.begin(), liquid.end());
    ans1 = liquid[0];
    ans2 = liquid[1];

    int mix = 2000000000, idx;
    for(int i = 0; i < liquid.size(); ++i)
        binarySearch(liquid, i, mix, ans1, ans2);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, ans1, ans2;
    cin >> n;

    vector<int> liquid(n);
    for(int i = 0; i < n; ++i)
        cin >> liquid[i];

    solution(liquid, ans1, ans2);

    cout << ans1 << " " << ans2 << "\n";
    return 0;
}