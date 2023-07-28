#include <iostream>
#include <numeric>

#define MOD 1000000007

using namespace std;

long ModPow(long x, long y){
	if(y == 1) return x;
	if(y % 2 == 1) return x * ModPow(x, y-1) % MOD;

	long p = ModPow(x, y/2);
	return p * p % MOD;
}


int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long ans = 0;
    long m, n, s;
    cin >> m;

    while(m--)
    {
        cin >> n >> s;

        long gcd_num = gcd(n,s);
        n /= gcd_num;
        s /= gcd_num;

        ans += s * ModPow(n, MOD-2) % MOD;
        ans %= MOD;
    }

    cout << ans << "\n";
    return 0;
}
