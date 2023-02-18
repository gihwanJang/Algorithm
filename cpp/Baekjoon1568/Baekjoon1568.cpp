#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, ans = 0;
    cin >> N;

    for(int i = 1; N != 0; ++i){
        if(i <= N){
            N -= i;
            ++ans;
        }
        else
            i = 0;
    }

    cout << ans << "\n";
    return 0;
}
