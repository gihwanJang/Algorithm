#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int day, car, ans = 0;
    cin >> day;

    for(int i = 0; i < 5; ++i){
        cin >> car;

        if(car % 10 == day)
            ++ans;
    }

    cout << ans << "\n";
    return 0;
}
