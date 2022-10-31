#include <iostream>
#include<string>
#include <algorithm>

using namespace std;

string stringSum(string A, string B){
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

char cmp(string p, string n){
    if(p.length() != n.length())
        return p.length() > n.length() ? '+' : '-';
    else{
        if(p == n) return '0';
        else
            return p > n ? '+' : '-';
    }
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T = 3;
    while(T--){
        int N;
        cin >> N;

        string p = "0";
        string n = "0";

        for(string s; N > 0; --N){
            cin >> s;
            if(s[0] == '-')
                n = stringSum(n, s.substr(1, s.size() - 1));
            else
                p = stringSum(p, s.substr(0, s.size()));
        }
        
        cout << cmp(p , n) << "\n";
    }
    return 0;
}
