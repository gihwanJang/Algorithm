#include <iostream>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int spelling[26] = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    int dp[4000];
    string A, B;

    cin >> A >> B;
    for(int i = 0; i < A.length(); ++i){
        dp[2 * i] = spelling[A[i] - 65];
        dp[2 * i + 1] = spelling[B[i] - 65];
    }

    for(int i = A.length() * 2 - 1; i > 1; --i)
        for(int j = 0; j < i; ++j)
            dp[j] = (dp[j] + dp[j + 1]) % 10;

    cout << dp[0] << dp[1] << "\n";
    return 0;
}
