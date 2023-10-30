# (1157) 단어 공부
## :100: Algorithm
## 문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

## 입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

## 출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

## 풀이
해당 문제는 정렬을 이용하면 해결 할 수 있습니다.

입력 문자열의 문자 갯수를 세어 카운트 한 후 해당 문자의 갯수를 기준으로 정렬합니다.  

이후 앞뒤의 카운트 값이 같다면 '?'아니면 해당 문자를 출력합니다. 

<코드>
```cpp
#include <algorithm>
#include <iostream>
#include <string>

using  namespace std;

char getMostChar(string&s) {
    if(s.length() == 1) return toupper(s[0]);

    vector<pair<int,int>> charMap(26);
    for(int i = 0; i < 26; ++i) 
        charMap[i].second = i;
    for(int i = 0; i < s.length(); ++i) 
        --charMap[toupper(s[i]) - 'A'].first;
    sort(charMap.begin(), charMap.end());

    if(charMap[0].first == charMap[1].first) return '?';
    return charMap[0].second + 'A';
}

int main(int argc, char const *argv[]){
    string s;
    cin >> s;
    cout << getMostChar(s) << "\n";
    return 0;
}
``` 