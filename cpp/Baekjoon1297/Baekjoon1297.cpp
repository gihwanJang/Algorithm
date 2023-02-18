#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    double D, H, W, i;
    cin >> D >> H >> W;

    i = sqrt(H*H + W*W);

    cout << floor(H * D / i) << " " << floor(W * D / i) << "\n";    
    return 0;
}
