#include<iostream>
#include<vector>
using namespace std;

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    string s;
    vector<char> stack;
    cin >> T;
    for(; T > 0; --T){
        stack.clear();
        cin >> s;

        for(int i = 0; i < s.length(); ++i){
            if(stack.size() == 0) stack.push_back(s[i]);
            else{
                if(s[i] == ')' && stack.back() == '(')
                    stack.pop_back();
                else
                    stack.push_back(s[i]);
            }
        }

        cout <<(stack.size() == 0 ? "YES" :"NO") << "\n";
    }
    return 0;
}
