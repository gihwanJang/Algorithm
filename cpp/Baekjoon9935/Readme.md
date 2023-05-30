# (9935) 문자열 폭발
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/5543)
#
## 문제
상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.

폭발은 다음과 같은 과정으로 진행된다.

- 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
- 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
- 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.

상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다.

폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
#
## 입력
첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.

둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.

두 문자열은 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.
#
## 출력
첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.
#
## 풀이
해당 문제는 스택을 이용하면 해결 할 수 있는 문제입니다.  

문자열과 제거 문자열을 입력받습니다.  

이후 스택을 사용하는데 c++에서 제공하는 string 자료구조는 스택의 형식이므로 string자료구조를 사용하였습니다.  
해당 string에 문자를 하나씩 담고 마지막 문자열이 제거 문자열과 같으면 빼줍니다.  

모든 문자열의 문자를 한번 씩 넣었다면 스택에 남은 문자열을 출력해주면 됩니다.

이때 스택이 공백이면 "FRULA"를 출력해 주셔야합니다.

```cpp
#include <algorithm>
#include <iostream>
#include <string>

using namespace std;

void removeString(string&str, string&target){
    string res= "";
        
    for(int i = 0; i < str.size(); ++i){
        res.push_back(str[i]);

        if(res.size() >= target.size())
            if(res.substr(res.size() - target.size()) == target)
                for(int j = 0; j < target.size(); ++j)
                    res.pop_back();
    }

    str = res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s, t;
    cin >> s >> t;

    removeString(s, t);

    cout << (s.size() > 0 ? s : "FRULA") << "\n";
    return 0;
}
```