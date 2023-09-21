#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

void setTable(vector<long>&DP) {
    DP[0] = 1;
    for(int i = 1; i < 55; ++i)
        DP[i] = (DP[i-1] << 1) + (1L << i);
}

long getNumberOfOne(vector<long>&DP, long n) {
    long cnt = n & 1;
    int size = log(n) / log(2);

    for(int i = size; 0 < i; --i)
        if((n & (1L << i)) != 0L) {
            cnt += DP[i - 1] +(n - (1L << i) + 1);
            n -= (1L << i);
        }

    return cnt;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long a, b;
    cin >> a >> b;
    
    vector<long> DP(55);
    setTable(DP);

    cout << getNumberOfOne(DP, b) - getNumberOfOne(DP, a - 1);
    cout << "\n";
    return 0;
}
