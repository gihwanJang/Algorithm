#include<iostream>
#include<algorithm>
using namespace std;

int main(int argc, char const *argv[]){
    int n;
    scanf("%d", &n);
    int divisors[n];
    for(int i = 0; i < n; ++i)
        scanf("%d", &divisors[i]);
    
    sort(divisors, divisors+n);

    printf("%d\n", n==1 ? divisors[0]*divisors[0] : divisors[0]*divisors[n-1]);
    return 0;
}
