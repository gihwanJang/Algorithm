#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    set<int> set_num;

    for(int i = 0; i < numbers.size(); ++i)
        for(int j = i + 1; j < numbers.size(); ++j)
            set_num.insert(numbers[i] + numbers[j]);

    for(set<int>::iterator iter = set_num.begin(); iter != set_num.end(); ++iter)
        answer.push_back(*iter);

    return answer;
}

int main(int argc, char const *argv[]){
    vector<int> numbers = {2,1,3,4,1};
    vector<int> answer = solution(numbers);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << ", ";
    return 0;
}
