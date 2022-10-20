#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int ans = 50;
    string A, B;
    cin >> A >> B;

    for(int i = 0; i <= B.length() - A.length(); ++i){
        int cmp = 0;
        for(int j = 0; j < A.length(); ++j)
            if(A[j] != B[j + i])
                ++cmp;
        ans = min(ans, cmp);
    }

    cout << ans << "\n";
    return 0;
}
