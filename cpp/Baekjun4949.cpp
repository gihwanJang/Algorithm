#include<iostream>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    vector<char> stack;

    while(getline(cin, s)){
        if(s[0] == '.') break;
        stack.clear();
        for(int i = 0; i < s.length(); ++i){
            if(s[i] == '(' || s[i] == ')' || s[i] =='[' || s[i] == ']'){
                if(stack.size() == 0) stack.push_back(s[i]);
                else{
                    if((s[i] == ')' && stack.back() == '(') || (s[i] == ']' && stack.back() == '['))
                        stack.pop_back();
                    else
                        stack.push_back(s[i]);
                }
            }
        }
        printf("%s\n", stack.size() == 0 ? "yes" :"no");
    }
    return 0;
}
