#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum = 0, prev = -1, curr;
    for(int i = 0; i < 4; ++i){
        cin >> curr;

        if(prev == -1){
            prev = curr;
        }else if(curr > prev){
            sum += curr;
        }else{
            sum += prev;
            prev = curr;
        }
    }

    cin >> prev >> curr;

    sum += max(prev, curr);

    cout << sum << "\n";
    return 0;
}
