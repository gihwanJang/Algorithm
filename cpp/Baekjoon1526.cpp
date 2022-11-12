#include <iostream>
#include <vector>

using namespace std;

bool check(int n){
    string digit = to_string(n);
    for(int i = 0; i < digit.length(); ++i)
        if(digit[i] != '4' && digit[i] != '7')
             return true;

    return false;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, digit = 0;
    cin >> N;

    while(check(N))
        --N;

    cout << N << "\n";
    return 0;
}
