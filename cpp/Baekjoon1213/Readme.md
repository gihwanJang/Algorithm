# (1213) 팰린드롬 만들기
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1213)
#
## 문제
임한수와 임문빈은 서로 사랑하는 사이이다.

임한수는 세상에서 팰린드롬인 문자열을 너무 좋아하기 때문에, 둘의 백일을 기념해서 임문빈은 팰린드롬을 선물해주려고 한다.

임문빈은 임한수의 영어 이름으로 팰린드롬을 만들려고 하는데, 임한수의 영어 이름의 알파벳 순서를 적절히 바꿔서 팰린드롬을 만들려고 한다.

임문빈을 도와 임한수의 영어 이름을 팰린드롬으로 바꾸는 프로그램을 작성하시오.
#
## 입력
첫째 줄에 임한수의 영어 이름이 있다. 알파벳 대문자로만 된 최대 50글자이다.
#
## 출력
첫째 줄에 문제의 정답을 출력한다. 만약 불가능할 때는 "I'm Sorry Hansoo"를 출력한다. 정답이 여러 개일 경우에는 사전순으로 앞서는 것을 출력한다.
#
## 풀이
우선 입력 문장의 알파벳을 모두 카운트 합니다.  

이후 홀수 개의 알파벳을 카운트 합니다.  
홀수 개의 알파벳이 2개 이상 존재한다면 해당 문장은 팰린드롬 문장을 만들 수 없습니다.  

팰린드롬 문장을 만들 수 있는 경우 앞에서 부터 차례대로 (알파벳 갯수/2) 갯수 만큼 알파벳을 추가합니다.  

이후 전체에서 홀수 개로 존재하는 알파벳을 추가합니다.   

마지막 뒤에서 부터 차례대로 (알파벳 갯수/2) 갯수 만큼 알파벳을 추가합니다.  

최종적으로 만들어진 문자열을 출력해 주면됩니다.  

```cpp
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

```