#include<iostream>
#include<vector>
using namespace std;

vector<int> stack;

void operate(string s){
    int v;
    if(s == "push"){
        cin >> v;
        stack.push_back(v);
    }
    else if(s == "pop"){
        cout << (stack.size() == 0 ? -1 : stack.back()) << "\n";
        if(stack.size())stack.pop_back();
    }
    else if(s == "size")
        cout << stack.size() << "\n";
    else if(s == "empty")
        cout << (stack.empty() ? 1 : 0) << "\n";
    else
        cout << (stack.size() == 0 ? -1 : stack.back()) << "\n";
}

int main(int argc, char const *argv[]){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string s;

    cin >> n;

    for(; n > 0; --n){
        cin >> s;
        operate(s);
    }
    return 0;
}
