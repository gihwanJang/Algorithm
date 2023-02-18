#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    long long tmp = 0;
    int answer = 0;
    for(; n > 0; n /= 3){
        tmp *= 10;
        tmp += n % 3;
    }
    for(int i = 0; tmp > 0; tmp /= 10, ++i)
        answer += tmp % 10 * pow(3, i);
    return answer;
}

int main(int argc, char const *argv[]){
    cout << solution(27) << "\n";    
    return 0;
}
