#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = n - 1;
    
    for(int i = 2; i * i <= answer; ++i)
        if(answer % i == 0)
            answer = i;

    return answer;
}

int main(int argc, char const *argv[]){
    int n = 10;
    cout << solution(n) << "\n";
    return 0;
}
