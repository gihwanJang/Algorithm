#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, num;
    cin >> N;
    
    vector<int> v = {1000000};
    for (int i = 0; i < N; ++i){
        cin >> num;
        if (num > v.back())
            v.push_back(num);
        else{
            int idx = lower_bound(v.begin(), v.end(), num) - v.begin();
            v[idx] = num;
        }
    }
  
    cout << v.size();
    return 0;
}
