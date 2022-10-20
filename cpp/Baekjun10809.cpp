#include<iostream>
using namespace std;
int main(int argc, char const *argv[]){
    int alpa[26];
    fill_n(alpa, 26, -1); 
    string s;
    cin>>s;
    for(int i = 0; i<s.size(); ++i){
        if(alpa[s[i]-97]==-1)
            alpa[s[i]-97]=i;
    }
    for(int i = 0; i<26; ++i)
        cout<<alpa[i]<<" ";
    return 0;
}
