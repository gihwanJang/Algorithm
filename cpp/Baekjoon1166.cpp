#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L, W, H;
    cin >> N >> L >> W >> H;

    double lo = 0, hi = 1000000000, mid;
    for(int i = 0; i < 100000; ++i){
        mid = (lo + hi) / 2;
        if(long(L / mid) * long(W / mid) * long(H / mid) < N) hi = mid;
        else lo = mid;
    }
    
    cout.precision(10);
    cout << lo << "\n";
    return 0;
}
