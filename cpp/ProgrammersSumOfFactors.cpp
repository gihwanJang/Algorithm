#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;

    for(int i = 1; i * i <= n; ++i)
        if(n % i == 0)
            answer += i != n / i ? i + n / i : i;

    return answer;
}

int main(int argc, char const *argv[]){
    int n = 1;
    cout << solution(n) << "\n";
    return 0;
}
