#include<iostream>
using namespace std;

int trans = 0;

bool solution(string s){
    if(s.length() == 1) return ((s[0]-48)==3 || (s[0]-48)==6 || (s[0]-48)==9);
    ++trans;
    int next=0;
    for(int i = 0; i < s.length(); ++i)
        next += s[i] - 48;
    return solution(to_string(next));
}

int main(){
    string X;
    cin>>X;

    string s = solution(X) ? "YES" : "NO";

    cout<<trans<<endl;
    cout<<s<<endl;
    return 0;
}