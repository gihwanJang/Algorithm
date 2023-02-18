#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>

using namespace std;

int findMin(int n, vector<bool>&set){
    int res = 1000000000;

    for(int i = 1; i <= 1000; ++i)
        if(set[i])
            for(int j = i; j <= 1000; ++j)
                if(set[j])
                    for(int k = j; k <= 1001; ++k)
                        if(set[k])
                            res = min(res, abs(n - i * j * k));

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, S, num;
    cin >> N >> S;

    vector<bool> set(1001, true);    
    while(S--){
        cin >> num;
        set[num] = false;
    }

    cout << findMin(N, set) << "\n";
    return 0;
}
