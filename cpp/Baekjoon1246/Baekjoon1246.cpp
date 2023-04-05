#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void pricing(int n, int m, vector<int>&limt, int&ans1, int&ans2){
    sort(limt.begin(), limt.end());

    ans1 = limt[0];
    ans2 = limt[0] * (n > m ? m : n);
    
    for(int i = 1; i < m; ++i)
        if(ans2 < limt[i] * (n > m-i ? m-i : n)){
            ans1 = limt[i];
            ans2 = limt[i] * (n > m-i ? m-i : n);
        }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, ans1 = 0, ans2 = 0;
    cin >> n >> m;

    vector<int> limt(m);
    for(int i = 0; i < m; ++i)
        cin >> limt[i];

    pricing(n,m,limt,ans1,ans2);
    cout << ans1 << " " << ans2 << "\n";
    return 0;
}
