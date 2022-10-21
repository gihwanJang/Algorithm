#include<iostream>
using  namespace std;
int main(int argc, char const *argv[]){
    int max1=0,max2=1;
    int count[26]={0,};
    string s;
    cin>>s;
    for(size_t i=0; i<s.length(); ++i){
        s[i]=toupper(s[i]);
        ++count[s[i]-65];
    }

    for(size_t i=0; i<26; ++i)
        if(count[max1]<count[i])max1=i;
    for(size_t i=0; i<26; ++i)
        if(count[max2]<count[i]&&i!=max1)max2=i;
    
    if(s.length()!=1&&count[max1]==count[max2])
        cout<<"?"<<endl;
    else
        cout<<char(max1+65)<<endl;
    return 0;
}
