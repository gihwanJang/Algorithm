#include <iostream>
#include <cmath>

using namespace std;

int sumOfSequences(int L, int a){
    int sum = 0;
    for(int i = a; i - a < L; ++i)
        sum += i;
    return sum;
}

double check(int N, int L){
    double n = N, l = L;
    return n / l + 0.5 - l / 2;
}

void print(int L, int a){
    for(int i = a; i - a < L; ++i)
        cout << i << " ";
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L;
    cin >> N >> L;

    for(int a; L < 101; ++L){
        a = check(N, L);
        if(a < 0) break;
        if(sumOfSequences(L, a) == N ){
            print(L, a);
            return 0;
        }
    }

    cout << -1 << "\n";
    return 0;
}
