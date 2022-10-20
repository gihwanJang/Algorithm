#include <iostream>
using namespace std;

long long solution(int price, int money, int count){
    long long answer = 0;
    for(int i = 1; i <= count; ++i)
        answer += price * i;
    return answer > money ? answer - money : 0;
}

int main(int argc, char const *argv[]){
    cout << solution(1,2,3) << "\n";
    return 0;
}
