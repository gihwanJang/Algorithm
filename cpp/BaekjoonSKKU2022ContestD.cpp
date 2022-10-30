#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, ans;
    cin >> N;

    int start = 1, end = N, mid;

    for(int i = 0; i < 20 && end - start >= 0; ++i){
        mid = (start + end) / 2;
        cout << "? " << mid << endl;
        cin >> ans;
        if(mid == ans * 2){
            cout << "! " << mid << endl;
            return 0;
        }
        else if(mid > ans * 2)
            end = mid - 1;
        else
            start = mid + 1;
    }

    cout << "! 0" << endl;
    return 0;
}
