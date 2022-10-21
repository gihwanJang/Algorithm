#include<iostream>
using namespace std;
int solution(string s){
    int count=0;
    string change[7] = {"c=","c-","d-","lj","nj","s=","z="};

    for(size_t i=0; i<s.length(); ++i){
        if(s.substr(i,3)=="dz="){
            count+=2;
            i+=2;
        }
        else
            for (size_t j = 0; j<7; ++j)
                if(s.substr(i,2)==change[j]){
                    ++count;
                    ++i;
                    break;
                }        
    }

    return s.length()-count;
}
int main(int argc, char const *argv[]){
    string s;
    cin>>s;

    cout<<solution(s)<<endl;
    return 0;
}
