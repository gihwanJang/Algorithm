#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, cluster, *nums;
    long long answer = 0;
    cin >> n;
    nums = new int[n];
    for(int i = 0; i < n; ++i)
        cin >> nums[i];
    cin >> cluster;

    for(int i = 0; i < n; ++i)
        answer += ceil(double(nums[i])/cluster) * cluster;
    
    cout << answer << "\n";
    return 0;
}
