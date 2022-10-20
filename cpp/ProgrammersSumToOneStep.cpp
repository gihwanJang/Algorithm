#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> numbers) {
    int answer = 0;
    bool bitVector[10] = {false, };

    for(int i = 0; i < numbers.size(); ++i)
        bitVector[numbers[i]] = true;
    for(int i = 0; i < 10; ++i)
        if(!bitVector[i])
            answer += i;
    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> nums = {1,2,3,4};
    cout << solution(nums) << "\n";
    return 0;
}
