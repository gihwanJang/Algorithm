#include<cstdio>
using namespace std;

int n, k, mod = 1000000007;

long factorial(int N){
    long fac = 1;
		
    for(; N > 1; --N)
        fac = (fac * N) % mod;

    return fac;
}

long pow(int base, int expo){
	if(expo == 1) return base % mod;

    long temp = pow(base, expo / 2);

    return expo % 2 == 1 ? (temp * temp % mod) * base % mod : temp * temp % mod;
}

int main(int argc, char const *argv[]){
    long a, b;
    scanf("%d %d", &n, &k);
    a = factorial(n);
    b = factorial(k) * factorial(n - k) % mod;
    printf("%ld\n", a * pow(b, mod - 2) % mod);
    return 0;
}
