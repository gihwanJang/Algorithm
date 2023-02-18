#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int left, int right) {
    int answer = 0;
    for(int i = left; i <= right; ++i)
        answer +=  sqrt(i) == (int)sqrt(i) ? -i : i;
    return answer;
}

int main(int argc, char const *argv[]){
    cout << solution(13, 17) << "\n";
    return 0;
}
