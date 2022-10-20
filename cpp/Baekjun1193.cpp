#include<stdio.h>
#include<iostream>
#include<math.h>
using namespace std;

string solution(int n){
    int k=sqrt(2*(double)n-1.75)+0.5;
    int order=n-(k*(k-1)/2+1)+1;
    if(k%2==1)
        return to_string(k-order+1)+'/'+to_string(order);
    else
        return to_string(order)+'/'+to_string(k-order+1);
}

int main(int argc, char const *argv[]){
    int n;
    scanf("%d",&n);

    cout<<solution(n)<<endl;
    return 0;
}
