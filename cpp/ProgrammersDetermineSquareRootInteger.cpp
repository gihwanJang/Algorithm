#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(long long n) {
    long long answer = sqrt(n);
    return pow(answer, 2) == n ? pow(answer + 1, 2) : -1;
}

int main(int argc, char const *argv[]){
    long long n = 3;
    cout << solution(n) << "\n";    
    return 0;
}
