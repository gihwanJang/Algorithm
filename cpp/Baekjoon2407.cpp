#include <iostream>

using namespace std;

long long factorial(long long start, long long end){
    long long f = end;
    for(long i = start; i < end; ++i)
        f *= i;
    return f;
}

long long combin(long long n, long long m){
    long long big, small;
    if(n - m > m){
        big = n - m;
        small = m;
    }
    else{
        big = m;
        small = n - m;
    }
    return (factorial(big + 1, n) / factorial(1, small));
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long long n, m;
    cin >> n >> m;

    cout << (combin(n - 1, m - 1) + combin(n - 1, m)) << "\n";
    return 0;
}
