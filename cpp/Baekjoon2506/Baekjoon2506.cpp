#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, ans, score = 0, sum = 0;
    cin >> n;

    while(n--){
        cin >> ans;

        if(ans)
            sum += (++score);
        else
            score = 0;
    }

    cout << sum << "\n";
    return 0;
}
