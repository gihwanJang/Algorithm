#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s){
    stack<int> parenthesis;
    
    for(int i = 0; i < s.length(); ++i)
        if(!parenthesis.empty() && parenthesis.top() - s[i] == -1)
            parenthesis.pop();
        else
            parenthesis.push(s[i]);
    
    return parenthesis.empty();
}

int main(int argc, char const *argv[]){
    cout << solution("()()") << "\n";
    return 0;
}
