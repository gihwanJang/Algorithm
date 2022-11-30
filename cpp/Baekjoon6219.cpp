#include <iostream>
#include <vector>

using namespace std;

void findPrimeNumber(vector<bool>&prime){
    for (int i = 2; i * i < prime.size(); i++){
        if (!prime[i])
            continue;

        for (int j = i * i; j < prime.size(); j += i)
            prime[j] = false;
    }
}

bool checkIncludeNum(int num, int d){
    for(; num > 0; num /= 10)
        if(num % 10 == d)
            return true;
    return false;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int A, B, D, answer = 0;
    cin >> A >> B >> D;

    vector<bool> prime (B + 1, true);
    findPrimeNumber(prime);

    for(int i = A; i <= B; ++i)
        if(prime[i] && checkIncludeNum(i, D))
            ++answer;

    cout << answer << "\n";
    return 0;
}
