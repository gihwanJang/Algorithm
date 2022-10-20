#include <iostream>
#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    int small = a > b ? b : a, big = a > b ? a : b;

    for(; big >= small; ++small)
        answer += small;

    return answer;
}

int main(int argc, char const *argv[]){
    cout << solution(3, 5) << "\n";
    return 0;
}
