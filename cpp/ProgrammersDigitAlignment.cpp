#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(int a, int b){
    return a > b;
}

long long solution(long long n) {
    long long answer = 0;
    vector<int> tmp;
    for(; n > 0; n /= 10) tmp.push_back(n % 10);
    sort(tmp.begin(), tmp.end(), cmp);
    for(int i = 0; i < tmp.size(); ++i, answer *= 10)
        answer += tmp[i];
    return answer / 10;
}

int main(int argc, char const *argv[]){
    long long n = 118372;
    cout << solution(n) << "\n";
    return 0;
}
