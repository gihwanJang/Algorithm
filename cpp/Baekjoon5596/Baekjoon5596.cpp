#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum1 = 0;
    int sum2 = 0;
    int score;

    for(int i = 0; i < 4; ++i){
        cin >> score;
        sum1 += score;
    }
    for(int i = 0; i < 4; ++i){
        cin >> score;
        sum2 += score;
    }

    cout << (sum2 > sum1 ? sum2 : sum1) << "\n";
    return 0;
}
