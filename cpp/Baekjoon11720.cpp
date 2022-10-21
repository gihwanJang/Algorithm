#include<iostream>
#include<sstream>
using namespace std;

int main(int argc, char const *argv[]){
    int n,sum=0;
    string s;
    cin>>n>>s;
    for(int i=0;i<n;++i)
        sum+=s[i]-48;
    cout<<sum;
    return 0;
}
