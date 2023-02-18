#include <iostream>

using namespace std;

int solution(int n){
    int answer = 0;

    for(; n > 0; n /= 10)
        answer += n % 10;

    return answer;
}

int main(int argc, char const *argv[]){
    int n = 987;
    cout << solution(n) << "\n";
    return 0;
}
