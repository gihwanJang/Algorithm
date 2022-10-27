#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, cnt = 0;
    cin >> N;
    
    for(int i = 1; i <= N; ++i)
        for(int j = i, k; j > 0; j /= 10){
            k = j % 10;
            if(k == 3 || k == 6 || k == 9)
                ++cnt;
        }

    cout << cnt << "\n";
    return 0;
}