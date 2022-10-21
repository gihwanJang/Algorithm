#include<iostream>
#include<string>
#include <algorithm>
using namespace std;

string solution(string A, string B){
    string s="", num;
    int short_length, long_length, carry =0;
    bool flag=true;

    if(A.length()>B.length()){
        short_length = B.length();
        long_length = A.length();
        num = A;
    }
    else{
        short_length = A.length();
        long_length = B.length();
        num = B;
    }

    for(size_t i = 0; i < short_length; ++i){
        int val = (A[A.length()-i-1]-48) + (B[B.length()-i-1]-48)+carry;
        carry = val / 10;
        s += to_string(val%10);
    }

    for(size_t i = short_length; i < long_length; ++i){
        int val = (num[num.length()-i-1]-48) + carry;
        carry = val / 10;
        s += to_string(val%10);
    }

    if (carry!=0) s += to_string(carry);

    reverse(s.begin(), s.end());

    return s;
}

int main(int argc, char const *argv[]){
    string A, B;
    cin>>A>>B;

    cout<<solution(A, B)<<endl;
    return 0;
}
