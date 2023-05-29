#include <algorithm>
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int res = 1234567891;
    
    int bugger[3];
    for(int i = 0; i < 3; ++i)
        cin >> bugger[i];

    int drink[2];
    for(int i = 0; i < 2; ++i)
        cin >> drink[i];

    for(int i = 0; i < 3; ++i)
        for(int j = 0; j < 2; ++j)
            res = min(bugger[i] + drink[j] - 50, res);
    
    cout << res << "\n";
    return 0;
}
