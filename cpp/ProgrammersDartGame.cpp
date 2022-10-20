#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    vector<int> nums;
    for(int i = 0; i < dartResult.size(); ++i){
        // 2
        if(dartResult[i] > 47 && dartResult[i] < 58){
            if(dartResult[i] == 48 && i != 0 && dartResult[i - 1] == 49)
                nums.back() = 10;
            else
                nums.push_back(dartResult[i] - 48);
        }
        // 3
        if(dartResult[i] == 'D') nums.back() *= nums.back();
        if(dartResult[i] == 'T') nums.back() *= pow(nums.back(),2);
        // 4
        if(dartResult[i] == '*'){
            nums.back() *=2;
            if(nums.size() > 1) nums[nums.size() - 2] *= 2;
        }
        if(dartResult[i] == '#') nums.back() *= -1;
    }

    for(int i = 0; i < nums.size(); ++i)
        answer += nums[i];

    return answer;
}

int main(int argc, char const *argv[]){
    cout << solution("1D2S#10S") << "\n";
    return 0;
}
