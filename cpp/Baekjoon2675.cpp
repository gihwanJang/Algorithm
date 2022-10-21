#include<iostream>
using namespace std;
int main(int argc, char const *argv[]){
    int T;
    cin>>T;
    for(; T>0; --T){
        int n;
        string s;
        cin>>n>>s;
        for(int i=0; i<s.size(); ++i)
            for(int j=0; j<n; ++j)
                cout<<s[i];
        cout<<endl;
    }
    return 0;
}
