#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> bowls(3);
    for(int i = 0; i < 3; ++i)
        cin >> bowls[i];

    sort(bowls.begin(), bowls.end());    

    cout << bowls[1] << "\n";
    return 0;
}
