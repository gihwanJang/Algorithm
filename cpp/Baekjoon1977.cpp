#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int lo, hi, sum = 0, m = 100000;
    cin >> lo >> hi;

    for(; lo <= hi; ++lo){
        for(int i = 1; i*i <= lo; ++i)
            if(i*i == lo)
                sum += lo;
        
        if(m > sum && sum != 0)
            m = sum;
    }
    
    if(m == 100000){
        cout << -1 << "\n";
        return 0;
    }

    cout << sum << "\n";
    cout << m << "\n";
    return 0;
}
