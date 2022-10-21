#include<iostream>
using namespace std;

int main(int argc, char const *argv[]){
    int sum=0;
    string s;
    cin>>s;

    for(size_t i=0; i<s.length(); ++i){
        int asci=s[i]-65;
        if(asci<18)sum+=asci/3+3;
        else if(asci<25)sum+=(asci-1)/3+3;
        else sum+=10;
    }

    cout<<sum<<endl;
    return 0;
}
