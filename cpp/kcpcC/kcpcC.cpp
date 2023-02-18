#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);
    cout.tie(NULL);

    int T, s, t;
    long long n, currLen, currTime;

    cin >> T;
    while(T--){
        cin >> n >> s >> t;

        currLen = 1;
        currTime = s;

        while(currLen * 2 <= n){
            currTime += (currLen * s >= t ? t : (currLen * s));
            currLen *= 2;
        }

        cout << currTime + ((n - currLen) * s) << "\n";
    }
    return 0;
}
