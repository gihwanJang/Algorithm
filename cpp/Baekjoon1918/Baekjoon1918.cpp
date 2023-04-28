#include <iostream>

using namespace std;

string postfix(string s){
    string stack;
    string res;

    for (int i = 0; i < s.length(); ++i){
        if (s[i] >= 'A' && s[i] <= 'Z')
            res += s[i];
        else{
            if (s[i] == '(')
                stack.push_back(s[i]);
            else if (s[i] == '*' || s[i] == '/') {
                while (!stack.empty() && (stack.back() == '*' || stack.back() == '/')) {
                    res.push_back(stack.back());
                    stack.pop_back();
                }
                stack.push_back(s[i]);
            }
            else if (s[i] == '+' || s[i] == '-'){
                while (!stack.empty() && stack.back() != '(') {
                    res.push_back(stack.back());
                    stack.pop_back();
                }
                stack.push_back(s[i]);
            }
            else {
                while (!stack.empty() && stack.back() != '(') {
                    res.push_back(stack.back());
                    stack.pop_back();
                }
                stack.pop_back();
            }
        }
    }

    while (!stack.empty()) {
        res.push_back(stack.back());
        stack.pop_back();
    }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << postfix(s) << "\n";
    return 0;
}
