#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    string ans;
    vector<string> commends(N);
    for(int i = 0; i < N; ++i)
        cin >> commends[i];

    ans = commends[0];
    for(int l = 0; l < commends[0].length(); ++l)
        for(int i = 1 ; i < N; ++i)
            if(ans[l] != commends[i][l])
                ans[l] = '?';

    cout << ans << "\n";
    return 0;
}
