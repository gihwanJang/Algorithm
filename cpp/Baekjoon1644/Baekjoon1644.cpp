#include <iostream>
#include <vector>

using namespace std;

void findPrime(vector<int>&primeSum, int n){
    vector<bool> prime(n+1);

    for(int i = 2; i*i <= n; ++i)
        if(!prime[i])
            for(int j = i*i; j <= n; j += i)
                prime[j] = true;

    primeSum.push_back(0);
    for(int i = 2; i <= n; ++i)
        if(!prime[i])
            primeSum.push_back(primeSum.back() + i);
}

int primeSum(int n){
    int cnt = 0, l = 0, r = 0;

    vector<int> primeSum;
    findPrime(primeSum, n);

    while(l <= r && r < primeSum.size()){
		if(primeSum[r] - primeSum[l] > n)
			++l;
		else if(primeSum[r] - primeSum[l] < n)
			++r;
		else{
			++cnt;
			++r;
		}
	}

    return cnt;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    cout << primeSum(n) << "\n";
    return 0;
}
