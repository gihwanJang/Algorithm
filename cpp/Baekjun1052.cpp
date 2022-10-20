#include <iostream>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K, bundle, answer = 0;
    cin >> N >> K;

    for(; ; ++answer, ++N){
        int cnt = 0;

        for(int t = N; t > 0; t /= 2)
          	if (t & 1)
          	    cnt++;

        if(cnt <= K) break;
    }

    cout << answer << "\n";
    return 0;
}