#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    while(N--){
        int y = 0, k = 0, ys, ks;
        for(int i = 0; i < 9; ++i){
            cin >> ys >> ks;
            y += ys;
            k += ks;
        }
        if(y == k)
            cout << "Draw\n";
        else
            cout << (y > k ? "Yonsei\n" : "Korea\n");
    }
    return 0;
}
