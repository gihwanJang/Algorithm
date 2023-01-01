#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int L, P, news;
    cin >> L >> P;

    for(int i = 0; i < 5; ++i){
        cin >> news;
        cout << news - L * P << " ";
    }
        
    return 0;
}
