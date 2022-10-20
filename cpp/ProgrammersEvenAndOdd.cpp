#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(int num) {
    return num & 1 ? "Odd" : "Even";
}

int main(int argc, char const *argv[]){
    int num = 10;

    cout << solution(num) << "\n";
    return 0;
}
