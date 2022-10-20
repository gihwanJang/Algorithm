#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    for(; n > 0; n /= 10) answer.push_back(n % 10);
    return answer;
}

int main(int argc, char const *argv[]){
    long long n = 1234798752;
    vector<int> answer = solution(n);
    for(int i = 0; i < answer.size(); ++i)
        cout << answer[i] << ", ";
    return 0;
}
