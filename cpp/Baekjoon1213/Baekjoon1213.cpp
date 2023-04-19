#include<algorithm>
#include <iostream>

using namespace std;

string palindrome(string&s){
    string res;
    int odd = 0;
    int alpha[26] = {0,};
    // 알파벳 갯수 카운트
    for(int i = 0; i < s.length(); ++i)
        ++alpha[s[i] - 'A'];
    // 홀수 갯수 알파벳 카운트
    for(int i = 0; i < 26; ++i)
        if(alpha[i]%2 == 1)
            ++odd;
    // 펠린드롬 유무 판별
    if(odd > 1)
        return "I'm Sorry Hansoo";
    // 앞에서 부터 문장을 만듬
    for(int i = 0; i < 26; i++)
        for(int j = 0; j < alpha[i]/2; j++)
            res += i + 'A';
    // 홀수 개 알파벳 추가
    for(int i = 0; i < 26; i++)
        if(alpha[i]%2) 
            res += i + 'A';
    // 뒤에서 부터 알파벳 추가
    for(int i = 25; i >= 0; i--)
        for(int j = 0; j < alpha[i]/2; j++)
            res += i + 'A';

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << palindrome(s) << "\n";
    return 0;
}
