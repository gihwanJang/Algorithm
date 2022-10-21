#include <iostream>
#include <algorithm>

using namespace std;

long gcd(long a, long b){
	return b ? gcd(b, a % b) : a;
}

long lcm(long a, long b){
    return a * b / gcd(a,b);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    long nums[5], answer = 1;
    for(int i = 0; i < 5; ++i){
        cin >> nums[i];
        answer *= nums[i];
    }
    
    for(int i = 0; i < 3; ++i)
        for(int j = i + 1; j < 4; ++j)
            for(int k = j + 1; k < 5; ++k)
                answer = min(answer, lcm(nums[i], lcm(nums[j], nums[k])));

    cout << answer << "\n";
    return 0;
}
