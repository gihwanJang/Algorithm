#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    for(; num > 1 && answer < 501; ++answer){
        if(num & 1) num = num * 3 + 1;
        else num /= 2;
    }
    return answer > 500 || num != 1 ? -1 : answer;
}

int main(int argc, char const *argv[]){
    cout << solution(1) << "\n";
    return 0;
}
