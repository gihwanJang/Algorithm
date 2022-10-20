#include<stdio.h>
#include<string>
using namespace std;
string compare(int a,int b){
    if(a==b)return "==";
    return a>b? ">" : "<";
}
int main(int argc, char const *argv[]){
    int a,b;
    string s;
    scanf("%d %d",&a,&b);
    s=compare(a,b);
    printf("%s",s.c_str());
    return 0;
}
