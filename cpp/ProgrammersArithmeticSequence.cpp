#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    for(int i = x; n > 0; --n, i += x)
        answer.push_back(i);
    return answer;
}

int main(int argc, char const *argv[]){
    vector<long long> answer = solution(-4, 5);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << ", ";
    return 0;
}
