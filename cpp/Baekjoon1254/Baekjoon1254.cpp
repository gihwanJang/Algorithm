#include <iostream>
#include <algorithm>

using namespace std;

bool isPalindrome(string str){
    int len = str.length(), half = (len >> 1);
    for(int i = 0; i <= half; ++i)
        if(str[i] != str[len - i - 1])
            return false;
    return true;
}

int makePalindrop(string str){
    int len = str.length();
    for(int i = 0; i < len; ++i)
        if(isPalindrome(str.substr(i)))
            return i + len;
    return (len << 1);
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << makePalindrop(s) << "\n";
    return 0;
}