# (1918) 후위 표기식
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/1918)
#
## 문제
수식은 일반적으로 3가지 표기법으로 표현할 수 있다. 연산자가 피연산자 가운데 위치하는 중위 표기법(일반적으로 우리가 쓰는 방법이다), 연산자가 피연산자 앞에 위치하는 전위 표기법(prefix notation), 연산자가 피연산자 뒤에 위치하는 후위 표기법(postfix notation)이 그것이다. 예를 들어 중위 표기법으로 표현된 a+b는 전위 표기법으로는 +ab이고, 후위 표기법으로는 ab+가 된다.

이 문제에서 우리가 다룰 표기법은 후위 표기법이다. 후위 표기법은 위에서 말한 법과 같이 연산자가 피연산자 뒤에 위치하는 방법이다. 이 방법의 장점은 다음과 같다. 우리가 흔히 쓰는 중위 표기식 같은 경우에는 덧셈과 곱셈의 우선순위에 차이가 있어 왼쪽부터 차례로 계산할 수 없지만 후위 표기식을 사용하면 순서를 적절히 조절하여 순서를 정해줄 수 있다. 또한 같은 방법으로 괄호 등도 필요 없게 된다. 예를 들어 a+b*c를 후위 표기식으로 바꾸면 abc*+가 된다.

중위 표기식을 후위 표기식으로 바꾸는 방법을 간단히 설명하면 이렇다. 우선 주어진 중위 표기식을 연산자의 우선순위에 따라 괄호로 묶어준다. 그런 다음에 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨주면 된다.

예를 들어 a+b*c는 (a+(b*c))의 식과 같게 된다. 그 다음에 안에 있는 괄호의 연산자 *를 괄호 밖으로 꺼내게 되면 (a+bc*)가 된다. 마지막으로 또 +를 괄호의 오른쪽으로 고치면 abc*+가 되게 된다.

다른 예를 들어 그림으로 표현하면 A+B*C-D/E를 완전하게 괄호로 묶고 연산자를 이동시킬 장소를 표시하면 다음과 같이 된다.

![표기식](https://upload.acmicpc.net/5aad2feb-d9fc-430a-954d-73a06ba0215f/-/preview/)

결과: ABC*+DE/-

이러한 사실을 알고 중위 표기식이 주어졌을 때 후위 표기식으로 고치는 프로그램을 작성하시오


#
## 입력
첫째 줄에 중위 표기식이 주어진다. 단 이 수식의 피연산자는 알파벳 대문자로 이루어지며 수식에서 한 번씩만 등장한다. 그리고 -A+B와 같이 -가 가장 앞에 오거나 AB와 같이 *가 생략되는 등의 수식은 주어지지 않는다. 표기식은 알파벳 대문자와 +, -, *, /, (, )로만 이루어져 있으며, 길이는 100을 넘지 않는다. 
#
## 출력
첫째 줄에 후위 표기식으로 바뀐 식을 출력하시오
#
## 풀이
해당 문제는 스택을 이용하면 되는 문제입니다.  

우선 스택으로 이용할 자료구조로 string을 사용합니다.  
string 자료구조를 이용하여 push_back연산와 pop_back연산을 사용하면 스택에서의 push와 pop을 하는 동일한 결과를 도출 할 수 있습니다.  

string자료구조를 이용하여 주어진 식을 선형 검색하며 아래의 과정을 수행합니다.  

1. 피연산자 즉 영어 대문자 알파벳인 경우
    - 해당 피연산자를 결과 문자열에 추가
        - 수식 트리에서 피연산자는 무조건 말단 노드에 위치하게 되고 후위 순회는 말단 노드를 우선으로 방문하기 때문

2. 피연산자가 아닌 경우 측 연산자인 '(', ')', '+', '-', '*', '/' 경우
    1. 연산자가 '('인 경우
        - 스택에 해당 연산자를 추가
            - '('해당 연산자는 우선순위가 높음으로 안에 있는 연산자는 후위 순회를 하기 때문에 순서가 바뀌어 출력되기 때문
    2. 연산자가 '*', '/'인 경우
        - 스택에 해당 연산자와 같은 연산자가 있다면 동일한 우선 순위이므려 결과 문자열에 추가
        - 이후 해당 연산자를 스택에 입력
            - '*', '/'인 연산자 보다 뒤에 우선순위가 낮은 '+', '-'연산자가 올 수 있기 때문
    3. 연산자가 '+', '-'인 경우
        - 스택의 처음이 '('가 아니라면 스택의 처음이 '('일때 까지 결과 문자열에 스택 값 추가
        - 스택에 연산자를 추가
            - '+', '-'연산자는 우선순위가 가장 낮기 때문에 가장 나중에 출력
    4. 연산자가 ')'인 경우
        - 스택의 마지막이 '('일때 까지 결과 문자열에 스택의 값 추가
        - '('를 스택에서 제거

위의 과정이 끝나면 결과 문자열을 출력해 주시면 됩니다.  

```cpp
#include <iostream>

using namespace std;

string postfix(string s){
    string stack;
    string res;

    for (int i = 0; i < s.length(); ++i){
        if (s[i] >= 'A' && s[i] <= 'Z')
            res += s[i];
        else{
            if (s[i] == '(')
                stack.push_back(s[i]);
            else if (s[i] == '*' || s[i] == '/') {
                while (!stack.empty() && (stack.back() == '*' || stack.back() == '/')) {
                    res.push_back(stack.back());
                    stack.pop_back();
                }
                stack.push_back(s[i]);
            }
            else if (s[i] == '+' || s[i] == '-'){
                while (!stack.empty() && stack.back() != '(') {
                    res.push_back(stack.back());
                    stack.pop_back();
                }
                stack.push_back(s[i]);
            }
            else {
                while (!stack.empty() && stack.back() != '(') {
                    res.push_back(stack.back());
                    stack.pop_back();
                }
                stack.pop_back();
            }
        }
    }

    while (!stack.empty()) {
        res.push_back(stack.back());
        stack.pop_back();
    }

    return res;
}

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;

    cout << postfix(s) << "\n";
    return 0;
}
```