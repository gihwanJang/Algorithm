#include <iostream>

using namespace std;

int isPalindrome(string s, int&count){
    int l = 0;
    int r = s.length() - 1;

    ++count;
    for(; s[l] == s[r]; ++l, --r, ++count)
        if(l >= r)
            return 1;
    
    return 0;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T, count;
    cin >> T;

    string s;

    while(T--){
        cin >> s;

        count = 0;

        cout << isPalindrome(s, count) << " " << count << "\n";
    }
}