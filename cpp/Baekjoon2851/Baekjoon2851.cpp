#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int low = 0, high = 500, num;
    bool flag = true;
    
    for(int i = 0; i < 10; ++i){
        cin >> num;
        if(low + num <= 100 && flag)
            low += num;
        else if(flag){
            high = low + num;
            flag = false;
        }
    }

    cout << (100 - low < high - 100 ? low : high) << "\n";
    return 0;
}
