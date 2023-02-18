#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K;
    cin >> N >> K;

    int start = 1, end = K, result = -1;
    while (start <= end) {
        int cnt = 0;
        int mid = (start + end) / 2;
        
        for (int i = 1; i <= N; i++) {
            cnt += min(mid/i, N);
        }
        
        if (cnt < K) start = mid + 1;
        else {
            result = mid;
            end = mid - 1;
        }
    }

    cout << result << "\n";
    return 0;
}
