#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum = 0, score;

    for(int i = 0; i < 5; ++i){
        cin >> score;
        if(score < 40)
            score = 40;
        sum += score;
    }

    cout << sum / 5 << "\n";
    return 0;
}
