#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    for(int i = 1, k; i <= n; ++i){
        k = n / i - (i - 1) / 2;
        if(k <= 0) break;
        if((2 * k + i - 1) * i / 2 == n) ++answer;
    }
    return answer;
}

int main(int argc, char const *argv[]){
    cout << solution(1) << "\n";
    return 0;
}
