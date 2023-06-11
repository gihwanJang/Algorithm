# (10768) 특별한날
## :100: Algorithm
[문제 바로가기](https://www.acmicpc.net/problem/10768)
#
## 문제
2월 18일은 올해 CCC에 있어서 특별한 날이다.

사용자로부터 정수인 월과 일을 입력받아 날짜가 2월 18일인지 전인지 후인지를 출력하는 프로그램이다.

만약 날짜가 2월 18일 전이면, "Before"을 출력한다. 만약 날짜가 2월 18일 후면, "After"을 출력한다. 만약 2월 18일이라면 "Special" 을 출력한다.
#
## 입력
입력은 두 개의 정수가 각 줄에 걸쳐 입력된다. 이 정수들은 2015년의 날짜에 포함된다.

첫 번째 줄은 1에서 12사이의 월을 입력한다.

두 번째 줄은 1에서 31사이의 그 달에 들어있는 날짜를 입력한다 .
## 출력
마지막 줄에 "Before", "After"나 "Special"을 출력한다.
#
## 풀이
month와 day를 입력받습니다.  

month가 2보다 크면 'After'을 작으면 'Before'을 출력합니다.  
month가 2인 경우 day가 18보다 크면 'After'을 작으면 'Before'을 같으면 'Special'을 출력합니다.  

```cpp
#include <iostream>

using namespace std;

int main(int argc, char const *argv[]){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int m, d;
    cin >> m >> d;

    if(m > 2)
        cout << "After\n";
    else if(m == 2){
        if(d > 18)
            cout << "After\n";
        else if(d == 18)
            cout << "Special\n";
        else
            cout << "Before\n";
    }
    else
        cout << "Before\n";
    return 0;
}
```