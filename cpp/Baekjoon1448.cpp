#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> lines(n);
    for(int i = 0; i < n; ++i)
        cin >> lines[i];

    sort(lines.rbegin(), lines.rend());
    
    for(int i = 2; i < n; ++i)
        if(lines[i - 2] < lines[i - 1] + lines[i]){
            cout << lines[i] + lines[i - 1] + lines[i - 2] << "\n";
            return 0;
        }

    cout << -1 << "\n";
    return 0;
}
