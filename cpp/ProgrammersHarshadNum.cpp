#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int sum = 0;
    for(int tmp = x; tmp > 0; tmp /= 10)
        sum += tmp % 10;
    return x % sum == 0;
}

int main(int argc, char const *argv[]){
    int x = 12;
    cout << (solution(x) ? "true" : "false") << "\n";
    return 0;
}
