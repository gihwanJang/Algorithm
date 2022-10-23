#include <iostream>
#include <algorithm>

using namespace std;

long solution(long a, long b, long c){
    return (a + b) * (a + b) + c * c;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    long a, b, c, ans;

    cin >> T;
    while(T--){
        cin >> a >> b >> c;

        ans = min(solution(b, c, a), solution(a, c, b));
        ans = min(ans, solution(a, b, c));

        cout << ans << "\n";
    }
    return 0;
}
