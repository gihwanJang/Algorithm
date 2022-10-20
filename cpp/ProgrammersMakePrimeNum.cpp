#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<int> nums) {
    int answer = 0, n = 0;
    sort(nums.begin(), nums.end());
    for(int i = 1; i < 4; ++i)
        n += nums[nums.size() - i];
    vector<bool> PrimeNums(n + 1, true);

    for (int i = 2; i * i <= n; i++)
		if (PrimeNums[i])
			for (int j = i * i; j <= n; j += i){
			    PrimeNums[j] = false;
            }

    for(int f = 0; f < nums.size(); ++f)
        for(int s = f + 1; s < nums.size(); ++s)
            for(int t = s + 1; t < nums.size(); ++t)
                if(PrimeNums[nums[f] + nums[s] + nums[t]])
                    ++answer;

    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> nums = {1,2,7,6,4};
    cout << solution(nums) << "\n";
    return 0;
}
