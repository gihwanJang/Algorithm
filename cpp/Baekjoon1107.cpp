#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, k, num = 0;
    cin >> N >> M;

    vector<bool> nums(10, true);
    while(M--){
        cin >> k;
        nums[k] = false;
    }

    return 0;
}
