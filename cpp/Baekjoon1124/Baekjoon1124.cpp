#include <iostream>
#include <vector>

using namespace std;

void setPrime(vector<bool>&primes){
    primes[0] = primes[1] = true;
    for (int i = 2; i * i <= primes.size(); ++i)
		if (primes[i] == false)
			for (int j = i + i; j <= primes.size(); j += i)
				primes[j] = true;
}

bool checkUnderPrime(int num, vector<bool>&primes){
    int primCount = 0;

    for(int i = 2; i <= num; ++i){
        while(num % i == 0){
            num /= i;
            ++primCount;
        }
        while(primes[i + 1])
            ++i;
    }

    if(!primes[primCount])
        return true;
    return false;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int A, B, ans = 0;
    cin >> A >> B;

    vector<bool> primes(B + 2);
    setPrime(primes);

    for(int n = A; n <= B; ++n)
        if(checkUnderPrime(n, primes))
            ++ans;

    cout << ans << "\n";
    return 0;
}
