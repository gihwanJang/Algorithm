#include <iostream>

using namespace std;

int reverse(int num){
    int ans = 0;
    while(num){
        ans *= 10;
        ans += num % 10;
        num /= 10;
    }
    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int X, Y;
    cin >> X >> Y;

    cout << reverse(reverse(X) + reverse(Y)) << "\n";
    return 0;
}
