#include<iostream>
#include<string>
using namespace std;

int readNum(string s){
    char temp=s[0];
    s[0]=s[2];
    s[2]=temp;
    return stoi(s);
}

int main(int argc, char const *argv[]){
    string s1,s2;
    cin>>s1>>s2;
    int num1=readNum(s1),num2=readNum(s2);
    cout<<(num1>num2?num1:num2)<<endl;
    return 0;
}
