#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    return stoi(s);
}

int main(int argc, char const *argv[]){
    string s = "31247897";
    cout << solution(s) << "\n";
    return 0;
}
