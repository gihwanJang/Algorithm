#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<bool> nums(31, false);

    int T = 28, n;
    while(T--){
        cin >> n;
        nums[n] = true;
    }

    for(int i = 1; i < 31; ++i)
        if(!nums[i])
            cout << i << "\n";
    return 0;
}
