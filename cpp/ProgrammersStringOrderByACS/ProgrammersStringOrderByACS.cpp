#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(char a, char b){
    return a > b;
}

string solution(string s) {
    sort(s.begin(), s.end());
    return s;
}

int main(int argc, char const *argv[]){
    cout << solution("gfedcbZ") << "\n";
    return 0;
}
