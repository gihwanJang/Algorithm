#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
    for(int i = 0; i < s.length(); ++i)
        if(s[i] < 48 || s[i] > 57)
            answer = false;
    return answer && (s.length() == 4 || s.length() == 6);
}

int main(int argc, char const *argv[]){
    cout << solution("a234") << "\n";    
    return 0;
}
