#include <iostream>
#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    if(b > a)
        return ((long long)b * (b + 1) - (long long)a * (a - 1)) / 2;
    return ((long long)a * (a + 1) - (long long)b * (b - 1)) / 2;
}

int main(int argc, char const *argv[]){
    cout << solution(1, 10000000) << "\n";
    return 0;
}
