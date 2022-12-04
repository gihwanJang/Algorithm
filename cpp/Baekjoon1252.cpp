#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string binarySum(string a, string b){
    string ans = "";
    char carry = '0';

    for(size_t i = 0; i < b.length(); ++i){
        if(a[a.length() - i - 1] == b[b.length() - i - 1]){
            ans += carry;
            carry = a[a.length() - i - 1] == '0' ? '0' : '1';
        }
        else{
            ans += carry == '0' ? '1' : '0';
            carry = ans.back() == '0' ? '1' : '0'; 
        }
    }

    for(size_t i = b.length(); i < a.length(); ++i){
        if(carry == a[a.length() - i - 1]){
            ans += '0';
            carry = a[a.length() - i - 1] == '0' ? '0' : '1';
        }
        else{
            ans += '1';
            carry = '0';
        }
    }

    if(carry == '1')
        ans += carry;
    
    while(ans.back() == '0' && ans.length() > 1)
        ans.pop_back();

    reverse(ans.begin(), ans.end());

    return ans;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string A, B;
    cin >> A >> B;

    cout << (A.length() > B.length() ? binarySum(A,B) : binarySum(B,A)) << "\n";
    return 0;
}
