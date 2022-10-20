#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<bool> PrimeNums(n + 1, true);

    for (int i = 2; i * i <= n; i++)
		if (PrimeNums[i])
			for (int j = i * i; j <= n; j += i){
			    PrimeNums[j] = false;
            }
	
    for(int i = 2; i < n + 1; ++i)
        if(PrimeNums[i])
            ++answer;

    return answer;
}

int main(int argc, char const *argv[]){
    cout << solution(5) << "\n";
    return 0;
}
