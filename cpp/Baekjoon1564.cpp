#include <iostream>

using namespace std;

long factorial(int n){
    long fac = 1;

    for(; n > 1; --n){
        fac *= n;

        while(fac % 10 == 0)
            fac /=10;
        
        fac %= 1000000000000;
    }

    return fac % 100000;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    cout.width(5);
    cout.fill('0'); 
    cout << factorial(N) << "\n";
    return 0;
}
