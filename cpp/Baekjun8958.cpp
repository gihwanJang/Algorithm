#include<iostream>
using namespace std;
int main(int argc, char const *argv[]){
    int T;
    cin>>T;
    for (; T >0; --T){
        int t_score=0;
        string s;
        cin>>s;
        for(int i=0,score=0; i<s.size(); ++i){
            if(s[i]=='X')score=0;
            else{
                ++score;
                t_score+=score;
            }
        }
        cout<<t_score<<endl;
    }
    return 0;
}
