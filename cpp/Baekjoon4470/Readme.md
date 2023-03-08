# (4470) 줄번호
## :100: Algorithm
## 문제
텍스트에서 줄을 입력받은 뒤, 줄 번호를 출력하는 프로그램을 작성하시오.

## 입력
첫째 줄에 줄의 수 N이 주어진다. 둘째 줄부터 N개의 줄에 각 줄의 내용이 주어진다. 각 줄에 있는 글자의 개수는 50글자를 넘지 않는다.

## 출력
각 문장의 앞에 줄 번호를 추가한 뒤 출력한다. 줄 번호는 1번부터 시작한다. 줄번호를 추가하는 형식은 출력 예제를 참고하면 된다.

## 풀이
cin의 경우 공백을 입력받지 못하기 때문에 getline을 사용해야 합니다.  
또한 cin 으로 정수를 입력 받은후 개행 문자가 남아있기 때문에 cin.ignore()를 통해 개행문자를 지워줍니다.  
이후는 그래도 번호와 입력 받은 문자열을 출력해 주시면됩니다.  

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    string s;
    cin.ignore();
    for(int i = 1; i <= n; ++i){
        getline(cin, s);
        
        cout << i << ". " << s << "\n";
    }
    return 0;
}

```