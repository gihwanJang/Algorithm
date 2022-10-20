#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    return s.substr((s.length()-1)/2,s.length() & 1 ? 1 : 2);
}

int main(int argc, char const *argv[]){
    cout << solution("asd") << "\n";
    return 0;
}
