#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    for(int i = 0; i + 4 < phone_number.length(); ++i)
        phone_number[i] = '*';
    return phone_number;
}

int main(int argc, char const *argv[]){
    cout << solution("010666668008") << "\n";
    return 0;
}
